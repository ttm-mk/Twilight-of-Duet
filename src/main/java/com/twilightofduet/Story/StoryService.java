package com.twilightofduet.Story;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.Character.RomanceCharacterRepository;
import com.twilightofduet.User.UserCommon.UsersBean;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * StoryService
 * 作成者 tsutsumi miki
 * 編集日 2025/5/22 tsutsumi miki
 */

@Service
public class StoryService {

	@Autowired
	UsersRepository userRepository;
	@Autowired
	StoryRepository storyRepository;
	@Autowired
	RomanceCharacterRepository characterRepository;
	
	/**
	 * ユーザー登録時のストーリーレコードの作成
	 * 
	 * @param user
	 * @return
	 */
	public String storyCreate(UsersEntity user) {
		
		if(user == null || user.getUserId() == null){ 
			throw new RuntimeException("ユーザー名が空なのでストーリーレコードを作成できません。");
			
		}
		
		try {
			// メインはメインストーリー
			storyRepository.save(new StoryEntity(characterRepository.findByCharacterName("メイン"), user, 0));
			storyRepository.save(new StoryEntity(characterRepository.findByCharacterName("園山巧美"), user, 0));
			storyRepository.save(new StoryEntity(characterRepository.findByCharacterName("小早川颯真"), user, 0));
			storyRepository.save(new StoryEntity(characterRepository.findByCharacterName("須王御幸"), user, 0));
			storyRepository.save(new StoryEntity(characterRepository.findByCharacterName("園山巧斗"), user, 0));
			storyRepository.save(new StoryEntity(characterRepository.findByCharacterName("相良実瑠"), user, 0));
			
		} catch(Exception e) {
			throw new RuntimeException("ストーリーレコードの作成は失敗しました。", e);
		}
		
		return "ok";
		
	}
	
	/**
	 * メインストーリーEntityの取得
	 * @param user
	 * @return
	 */
	public StoryEntity findMainStoryEntity(UsersBean user) {
		UsersEntity userEntity = userRepository.findByUserId(user.getUserId());
    	RomanceCharacterEntity characterEntity = characterRepository.findByCharacterName("メイン");
	    StoryEntity storyEntity = storyRepository.findByUserIdAndRomanceCharacterId(userEntity, characterEntity);
	    
	    return storyEntity;

	}
	
	/**
	 * メインストーリー数値を保存する処理
	 * 
	 * @param storyDTO　ストーリーSTO
	 * @param session　セッション情報
	 * @return　メインストーリーの数値　または　NULL
	 */
    @PostMapping("/story/main/save/complete")
    public Integer saveStoryMain(StoryDTO storyDTO, HttpSession session){
    	
    	// セッション情報からユーザー情報取得
    	UsersEntity userEntity = userRepository.findByUserId((Integer)session.getAttribute("userId"));
    	// キャラクターIDの取得
    	RomanceCharacterEntity characterEntity = characterRepository.findByCharacterName("メイン");
    	// ユーザー情報からストーリーID取得
    	StoryEntity storyEntity = storyRepository.findByUserIdAndRomanceCharacterId(userEntity, characterEntity);
    	// ストーリーSTOのメインストーリー数値をセット
    	storyEntity.setChapterNumber(storyDTO.getMainStory());
    	// メインストーリー数値の保存
    	storyRepository.save(storyEntity);
    	
    	if(storyEntity.getChapterNumber() == storyDTO.getMainStory()){
    		return storyEntity.getChapterNumber();
	    	  
	     } else {
	    	 return null;
	     }
      
      
    }

}
