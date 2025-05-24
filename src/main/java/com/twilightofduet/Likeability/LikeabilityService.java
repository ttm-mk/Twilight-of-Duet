package com.twilightofduet.Likeability;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.Character.RomanceCharacterRepository;
import com.twilightofduet.Story.StoryEntity;
import com.twilightofduet.Story.StoryRepository;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * LikeabilityService
 * 作成者 tsutsumi miki
 * 編集日 2025/5/25 tsutsumi miki
 */

@Service
public class LikeabilityService {
	
	@Autowired
	LikeabilityRepository likeabilityRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	RomanceCharacterRepository characterRepository;
	@Autowired
	StoryRepository storyRepository;
	
	/**
	 * 好感度テーブル作成時の値入力処理
	 * 
	 * @return
	 */
	public String likeabilityCreate(UsersEntity user) {
		
		if(user == null || user.getUserId() == null){ 
			throw new RuntimeException("ユーザー名が空なので好感度を作成できません。");
			
		}
		
		try{
			likeabilityRepository.save(new LikeabilityEntity(0, 0, user, characterRepository.findByCharacterName("園山巧美")));
			likeabilityRepository.save(new LikeabilityEntity(0, 0, user, characterRepository.findByCharacterName("小早川颯真")));
			likeabilityRepository.save(new LikeabilityEntity(0, 0, user, characterRepository.findByCharacterName("須王御幸")));
			likeabilityRepository.save(new LikeabilityEntity(0, 0, user, characterRepository.findByCharacterName("園山巧斗")));
			likeabilityRepository.save(new LikeabilityEntity(0, 0, user, characterRepository.findByCharacterName("相良実瑠")));
			
		} catch(Exception e) {
			throw new RuntimeException("好感度レコード作成に失敗しました", e);
			
		}
		
		return "ok";
		
	}
	
//	public String likeabilityCreate(UsersEntity user) {
//
//	    if (user == null || user.getUserId() == null) {
//	        throw new RuntimeException("ユーザー名が空なので好感度を作成できません。");
//	    }
//
//	    try {
//	        List<String> characters = List.of("園山巧美", "小早川颯真", "須王御幸", "園山巧斗", "相良実瑠");
//
//	        for (String name : characters) {
//	            RomanceCharacterEntity character = characterRepository.findByCharacterName(name);
//	            if (character == null) {
//	                throw new RuntimeException("キャラクターが見つかりません: " + name);
//	            }
//	            likeabilityRepository.save(new LikeabilityEntity(character, user, 0, 0));
//	        }
//
//	    } catch (Exception e) {
//	        throw new RuntimeException("好感度レコード作成に失敗しました", e);
//	    }
//
//	    return "ok";
//	}
	
	/**
	 * ストーリーIDがJS＞User情報の時、好感度保存処理を実施する
	 * TODO：ストーリータイプ分岐ができたらメソッド名の変更をする！
	 * 
	 * @param likeabilityDTO　好感度DTO
	 * @param storyDTO　ストーリーDTO
	 * @param session　セッション情報
	 * @return　判断値
	 */
	@PostMapping("/likeability/save")
	public Integer saveLikeability(LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session) {
		// 仮代入用変数のため、保存条件確定後削除
		Integer number;
		
		try {
			// likeabilityEntityから各種取得した好感度を代入
			LikeabilityEntity takumiLikeability = this.updateTakumiLikeability(likeabilityRequestDTO, session);
			LikeabilityEntity somaLikeability = this.updateSomaLikeability(likeabilityRequestDTO, session);
			LikeabilityEntity miyukiLikeability = this.updateMiyukiLikeability(likeabilityRequestDTO, session);
			LikeabilityEntity takutoLikeability = this.updateTakutoLikeability(likeabilityRequestDTO, session);
			LikeabilityEntity miruLikeability = this.updateMiruLikeability(likeabilityRequestDTO, session);
			
			return number=1;
			
		} catch(Exception e) {
			throw new RuntimeException("好感度保存に失敗しました。", e);
			
		}
		
	}
	
	/**
	 * 巧美の好感度更新
	 * 
	 * @param likeabilityRequestDTO
	 * @param session
	 * @return
	 */
	public LikeabilityEntity updateTakumiLikeability(LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session) {
		// ユーザーEntity取得
		UsersEntity userEntity = usersRepository.findByUserId((Integer)session.getAttribute("userId"));
		// キャラクターIDを取得
		RomanceCharacterEntity characterEntity = characterRepository.findByCharacterName("園山巧美");
		// ユーザーIDとキャラクターIDから好感度Entity取得
		LikeabilityEntity likeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, characterEntity);
		// 現在の好感度にDTOの値を足してセット
		likeabilityEntity.setCharacterLikeability(likeabilityEntity.getCharacterLikeability() + likeabilityRequestDTO.getTakumiLikeability());

		// mainとそれ以外のキャラクターで処理を分岐させる（TODO:あんまり入れ子にしたくないんだけどどうしよう）
		// mainとそれ以外のキャラクターで処理を分岐させる
		if(likeabilityRequestDTO.getStoryType().equals("main")){
			this.saveLikeabilityOfMainStory(userEntity, likeabilityRequestDTO, likeabilityEntity);
			
			return likeabilityEntity;
			
		} else {
			this.saveLikeabilityOfCharacterStory(userEntity, likeabilityRequestDTO, likeabilityEntity, characterEntity);
			
			return likeabilityEntity;

		}
		
	}
	
	/**
	 * 颯真の好感度更新
	 * 
	 * @param likeabilityRequestDTO
	 * @param session
	 * @return
	 */
	public LikeabilityEntity updateSomaLikeability(LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session) {
		// ユーザーEntity取得
		UsersEntity userEntity = usersRepository.findByUserId((Integer)session.getAttribute("userId"));
		// キャラクターIDを取得
		RomanceCharacterEntity characterEntity = characterRepository.findByCharacterName("小早川颯真");
		// ユーザーIDとキャラクターIDから好感度Entity取得
		LikeabilityEntity likeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, characterEntity);
		// 現在の好感度にDTOの値を足してセット
		likeabilityEntity.setCharacterLikeability(likeabilityEntity.getCharacterLikeability() + likeabilityRequestDTO.getSomaLikeability());
		
		// mainとそれ以外のキャラクターで処理を分岐させる
		if(likeabilityRequestDTO.getStoryType().equals("main")){
			this.saveLikeabilityOfMainStory(userEntity, likeabilityRequestDTO, likeabilityEntity);
			
			return likeabilityEntity;
			
		} else {
			this.saveLikeabilityOfCharacterStory(userEntity, likeabilityRequestDTO, likeabilityEntity, characterEntity);
			
			return likeabilityEntity;

		}

	}
	
	/**
	 * 御幸の好感度更新
	 * 
	 * @param likeabilityRequestDTO
	 * @param session
	 * @return
	 */
	public LikeabilityEntity updateMiyukiLikeability(LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session) {
		// ユーザーEntity取得
		UsersEntity userEntity = usersRepository.findByUserId((Integer)session.getAttribute("userId"));
		// キャラクターIDを取得
		RomanceCharacterEntity characterEntity = characterRepository.findByCharacterName("須王御幸");
		// ユーザーIDとキャラクターIDから好感度Entity取得
		LikeabilityEntity likeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, characterEntity);
		// 現在の好感度にDTOの値を足してセット
		likeabilityEntity.setCharacterLikeability(likeabilityEntity.getCharacterLikeability() + likeabilityRequestDTO.getMiyukiLikeability());

		// mainとそれ以外のキャラクターで処理を分岐させる
		if(likeabilityRequestDTO.getStoryType().equals("main")){
			this.saveLikeabilityOfMainStory(userEntity, likeabilityRequestDTO, likeabilityEntity);
			
			return likeabilityEntity;
			
		} else {
			this.saveLikeabilityOfCharacterStory(userEntity, likeabilityRequestDTO, likeabilityEntity, characterEntity);
			
			return likeabilityEntity;

		}

	}
	
	/**
	 * 巧斗の好感度更新
	 * 
	 * @param likeabilityRequestDTO
	 * @param session
	 * @return
	 */
	public LikeabilityEntity updateTakutoLikeability(LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session) {
		// ユーザーEntity取得
		UsersEntity userEntity = usersRepository.findByUserId((Integer)session.getAttribute("userId"));
		// キャラクターIDを取得
		RomanceCharacterEntity characterEntity = characterRepository.findByCharacterName("園山巧斗");
		// ユーザーIDとキャラクターIDから好感度Entity取得
		LikeabilityEntity likeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, characterEntity);
		// 現在の好感度にDTOの値を足してセット
		likeabilityEntity.setCharacterLikeability(likeabilityEntity.getCharacterLikeability() + likeabilityRequestDTO.getTakutoLikeability());

		// mainとそれ以外のキャラクターで処理を分岐させる
		if(likeabilityRequestDTO.getStoryType().equals("main")){
			this.saveLikeabilityOfMainStory(userEntity, likeabilityRequestDTO, likeabilityEntity);
			
			return likeabilityEntity;
			
		} else {
			this.saveLikeabilityOfCharacterStory(userEntity, likeabilityRequestDTO, likeabilityEntity, characterEntity);
			
			return likeabilityEntity;

		}

	}
	
	/**
	 * 実瑠の好感度更新
	 * 
	 * @param likeabilityRequestDTO
	 * @param session
	 * @return
	 */
	public LikeabilityEntity updateMiruLikeability(LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session) {
		// ユーザーEntity取得
		UsersEntity userEntity = usersRepository.findByUserId((Integer)session.getAttribute("userId"));
		// キャラクターIDを取得
		RomanceCharacterEntity characterEntity = characterRepository.findByCharacterName("相良実瑠");
		// ユーザーIDとキャラクターIDから好感度Entity取得
		LikeabilityEntity likeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, characterEntity);
		// 現在の好感度にDTOの値を足してセット
		likeabilityEntity.setCharacterLikeability(likeabilityEntity.getCharacterLikeability() + likeabilityRequestDTO.getMiruLikeability());

		// mainとそれ以外のキャラクターで処理を分岐させる
		if(likeabilityRequestDTO.getStoryType().equals("main")){
			this.saveLikeabilityOfMainStory(userEntity, likeabilityRequestDTO, likeabilityEntity);
			
			return likeabilityEntity;
			
		} else {
			this.saveLikeabilityOfCharacterStory(userEntity, likeabilityRequestDTO, likeabilityEntity, characterEntity);
			
			return likeabilityEntity;

		}

	}
	
	/**
	 * MainStoryの好感度をストーリー数値以下の時保存する
	 * @param userEntity
	 * @param likeabilityRequestDTO
	 * @param likeabilityEntity
	 * @return
	 */
	public LikeabilityEntity saveLikeabilityOfMainStory(UsersEntity userEntity,
			LikeabilityRequestDTO likeabilityRequestDTO, LikeabilityEntity likeabilityEntity) {
		
		// メインストーリーIDの取得
		RomanceCharacterEntity mainEntity = characterRepository.findByCharacterName("メイン");
		StoryEntity storyEntity = storyRepository.findByUserIdAndRomanceCharacterId(userEntity, mainEntity);
		Integer mainStoryNumber = storyEntity.getChapterNumber();
		
		// ユーザーのストーリーIDがJSから取得したストーリーIDより小さい場合に保存して数値を返す
		if(likeabilityRequestDTO.getStoryNumber() > mainStoryNumber) {
			likeabilityRepository.save(likeabilityEntity);
			
		} // TODO:そうじゃないときは何を返したらいいっけか？
		
		return likeabilityEntity;
		
	}
	
	/**
	 * CharacterStoryの好感度をストーリー数値以下の時保存する
	 * @param userEntity
	 * @param likeabilityRequestDTO
	 * @param likeabilityEntity
	 * @param characterEntity
	 * @return
	 */
	public LikeabilityEntity saveLikeabilityOfCharacterStory(UsersEntity userEntity, LikeabilityRequestDTO likeabilityRequestDTO,
			LikeabilityEntity likeabilityEntity, RomanceCharacterEntity characterEntity) {
		StoryEntity storyEntity = storyRepository.findByUserIdAndRomanceCharacterId(userEntity, characterEntity);
		Integer characterStoryNumber = storyEntity.getChapterNumber();
		
		// ユーザーのストーリーIDがJSから取得したストーリーIDより小さい場合に保存して数値を返す
		if(likeabilityRequestDTO.getStoryNumber() > characterStoryNumber) {
			likeabilityRepository.save(likeabilityEntity);
			
		} // TODO:そうじゃないときは何を返したらいいっけか？
		
		return likeabilityEntity;

	}

}
