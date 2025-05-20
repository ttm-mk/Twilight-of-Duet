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
 * 編集日 2025/5/21 tsutsumi miki
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
			likeabilityRepository.save(new LikeabilityEntity(characterRepository.findByRomanceCharacterId("園山巧美"), user, 0, 0));
			likeabilityRepository.save(new LikeabilityEntity(characterRepository.findByRomanceCharacterId("小早川颯真"), user, 0, 0));
			likeabilityRepository.save(new LikeabilityEntity(characterRepository.findByRomanceCharacterId("須王御幸"), user, 0, 0));
			likeabilityRepository.save(new LikeabilityEntity(characterRepository.findByRomanceCharacterId("園山巧斗"), user, 0, 0));
			likeabilityRepository.save(new LikeabilityEntity(characterRepository.findByRomanceCharacterId("相良実瑠"), user, 0, 0));
			
		} catch(Exception e) {
			throw new RuntimeException("好感度レコード作成に失敗しました", e);
			
		}
		
		return "ok";
		
	}
	
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
		
		// キャラクターIDを取得
		RomanceCharacterEntity Character = characterRepository.findByRomanceCharacterId("園山巧美");
		Integer CharacterId = Character.getRomanceCharacterId();
		// ユーザーIDとキャラクターIDから好感度Entity取得
		LikeabilityEntity likeabilityEntity = 
				likeabilityRepository.findByLikeabilityId((Integer)session.getAttribute("userId"), CharacterId);
		// 現在の好感度にDTOの値を足してセット
		likeabilityEntity.setCharacterLikeability(likeabilityEntity.getCharacterLikeability() + likeabilityRequestDTO.getTakumiLikeability());

		// ストーリーIDの取得
		StoryEntity storyEntity = storyRepository.findByStoryId((Integer)session.getAttribute("userId"), CharacterId);
		Integer mainStoryNumber = storyEntity.getChapterNumber();
		
		// ユーザーのストーリーIDがJSから取得したストーリーIDより小さい場合に保存して数値を返す
		if(likeabilityRequestDTO.getStoryNumber() > mainStoryNumber) {
			likeabilityRepository.save(likeabilityEntity);

		} // TODO:そうじゃないときは何を返したらいいっけか？
		
		return likeabilityEntity;
	}
	
	/**
	 * 颯真の好感度更新
	 * 
	 * @param likeabilityRequestDTO
	 * @param session
	 * @return
	 */
	public LikeabilityEntity updateSomaLikeability(LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session) {
		
		// キャラクターIDを取得
		RomanceCharacterEntity Character = characterRepository.findByRomanceCharacterId("小早川颯真");
		Integer CharacterId = Character.getRomanceCharacterId();
		// ユーザーIDとキャラクターIDから好感度Entity取得
		LikeabilityEntity likeabilityEntity = 
				likeabilityRepository.findByLikeabilityId((Integer)session.getAttribute("userId"), CharacterId);
		// 現在の好感度にDTOの値を足してセット
		likeabilityEntity.setCharacterLikeability(likeabilityEntity.getCharacterLikeability() + likeabilityRequestDTO.getSomaLikeability());

		// ストーリーIDの取得
		StoryEntity storyEntity = storyRepository.findByStoryId((Integer)session.getAttribute("userId"), CharacterId);
		Integer mainStoryNumber = storyEntity.getChapterNumber();
		
		// ユーザーのストーリーIDがJSから取得したストーリーIDより小さい場合に保存して数値を返す
		if(likeabilityRequestDTO.getStoryNumber() > mainStoryNumber) {
			likeabilityRepository.save(likeabilityEntity);

		} // TODO:そうじゃないときは何を返したらいいっけか？
		
		return likeabilityEntity;
	}
	
	/**
	 * 御幸の好感度更新
	 * 
	 * @param likeabilityRequestDTO
	 * @param session
	 * @return
	 */
	public LikeabilityEntity updateMiyukiLikeability(LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session) {
		
		// キャラクターIDを取得
		RomanceCharacterEntity Character = characterRepository.findByRomanceCharacterId("須王御幸");
		Integer CharacterId = Character.getRomanceCharacterId();
		// ユーザーIDとキャラクターIDから好感度Entity取得
		LikeabilityEntity likeabilityEntity = 
				likeabilityRepository.findByLikeabilityId((Integer)session.getAttribute("userId"), CharacterId);
		// 現在の好感度にDTOの値を足してセット
		likeabilityEntity.setCharacterLikeability(likeabilityEntity.getCharacterLikeability() + likeabilityRequestDTO.getMiyukiLikeability());

		// ストーリーIDの取得
		StoryEntity storyEntity = storyRepository.findByStoryId((Integer)session.getAttribute("userId"), CharacterId);
		Integer mainStoryNumber = storyEntity.getChapterNumber();
		
		// ユーザーのストーリーIDがJSから取得したストーリーIDより小さい場合に保存して数値を返す
		if(likeabilityRequestDTO.getStoryNumber() > mainStoryNumber) {
			likeabilityRepository.save(likeabilityEntity);

		} // TODO:そうじゃないときは何を返したらいいっけか？
		
		return likeabilityEntity;
	}
	
	/**
	 * 巧斗の好感度更新
	 * 
	 * @param likeabilityRequestDTO
	 * @param session
	 * @return
	 */
	public LikeabilityEntity updateTakutoLikeability(LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session) {
		
		// キャラクターIDを取得
		RomanceCharacterEntity Character = characterRepository.findByRomanceCharacterId("園山巧斗");
		Integer CharacterId = Character.getRomanceCharacterId();
		// ユーザーIDとキャラクターIDから好感度Entity取得
		LikeabilityEntity likeabilityEntity = 
				likeabilityRepository.findByLikeabilityId((Integer)session.getAttribute("userId"), CharacterId);
		// 現在の好感度にDTOの値を足してセット
		likeabilityEntity.setCharacterLikeability(likeabilityEntity.getCharacterLikeability() + likeabilityRequestDTO.getTakutoLikeability());

		// ストーリーIDの取得
		StoryEntity storyEntity = storyRepository.findByStoryId((Integer)session.getAttribute("userId"), CharacterId);
		Integer mainStoryNumber = storyEntity.getChapterNumber();
		
		// ユーザーのストーリーIDがJSから取得したストーリーIDより小さい場合に保存して数値を返す
		if(likeabilityRequestDTO.getStoryNumber() > mainStoryNumber) {
			likeabilityRepository.save(likeabilityEntity);

		} // TODO:そうじゃないときは何を返したらいいっけか？
		
		return likeabilityEntity;
	}
	
	/**
	 * 実瑠の好感度更新
	 * 
	 * @param likeabilityRequestDTO
	 * @param session
	 * @return
	 */
	public LikeabilityEntity updateMiruLikeability(LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session) {
		
		// キャラクターIDを取得
		RomanceCharacterEntity Character = characterRepository.findByRomanceCharacterId("相良実瑠");
		Integer CharacterId = Character.getRomanceCharacterId();
		// ユーザーIDとキャラクターIDから好感度Entity取得
		LikeabilityEntity likeabilityEntity = 
				likeabilityRepository.findByLikeabilityId((Integer)session.getAttribute("userId"), CharacterId);
		// 現在の好感度にDTOの値を足してセット
		likeabilityEntity.setCharacterLikeability(likeabilityEntity.getCharacterLikeability() + likeabilityRequestDTO.getMiruLikeability());

		// ストーリーIDの取得
		StoryEntity storyEntity = storyRepository.findByStoryId((Integer)session.getAttribute("userId"), CharacterId);
		Integer mainStoryNumber = storyEntity.getChapterNumber();
		
		// ユーザーのストーリーIDがJSから取得したストーリーIDより小さい場合に保存して数値を返す
		if(likeabilityRequestDTO.getStoryNumber() > mainStoryNumber) {
			likeabilityRepository.save(likeabilityEntity);

		} // TODO:そうじゃないときは何を返したらいいっけか？
		
		return likeabilityEntity;
	}

}
