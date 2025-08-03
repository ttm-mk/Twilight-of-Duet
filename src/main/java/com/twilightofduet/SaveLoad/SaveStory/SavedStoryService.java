package com.twilightofduet.SaveLoad.SaveStory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.Character.RomanceCharacterRepository;
import com.twilightofduet.SaveLoad.SaveFunction.SaveEntity;
import com.twilightofduet.SaveLoad.SaveStory.character.SavedCharacterStoryEntity;
import com.twilightofduet.SaveLoad.SaveStory.character.SavedCharacterStoryRepository;
import com.twilightofduet.SaveLoad.SaveStory.main.SavedMainStoryEntity;
import com.twilightofduet.SaveLoad.SaveStory.main.SavedMainStoryRepository;
import com.twilightofduet.Story.StoryEntity;
import com.twilightofduet.Story.StoryRepository;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/**
 * SaveLoadServiceコントローラ
 * 作成者 tsutsumi miki
 * 編集日 2025/7/31 tsutsumi miki
 */

@Service
public class SavedStoryService {
	
	@Autowired
	SavedCharacterStoryRepository savedCharacterStoryRepository;
	@Autowired
	SavedMainStoryRepository savedMainStoryRepository;
	@Autowired
	RomanceCharacterRepository romanceCharacterRepository;
	@Autowired
	StoryRepository storyRepository;
	@Autowired
	SavedCharacterStoryRepository savedCharacterStoryReposiory;
	@Autowired
	UsersRepository userRepository;
	
	
	/**
	 * キャラクターストーリーセーブ機能
	 * @param saveEntity
	 * @return
	 */
	public String saveCharacterStory(SaveEntity saveEntity) {
		
		if(saveEntity == null || saveEntity.getSaveId() == null) {
			throw new RuntimeException("saveEntityが空なのでストーリーを保存できません");
			
		}
		
		try {
			// 各キャラクターEntity取得
			RomanceCharacterEntity takumiEntity = romanceCharacterRepository.findByCharacterName("園山巧美");
			StoryEntity takumiStory = storyRepository.findByUserIdAndRomanceCharacterId(saveEntity.getUserId(), takumiEntity);
			Integer takumiChapterNumber = takumiStory.getChapterNumber();
			
			RomanceCharacterEntity somaEntity = romanceCharacterRepository.findByCharacterName("小早川颯真");
			StoryEntity somaStory = storyRepository.findByUserIdAndRomanceCharacterId(saveEntity.getUserId(), somaEntity);
			Integer somaChapterNumber = somaStory.getChapterNumber();
			
			RomanceCharacterEntity miyukiEntity = romanceCharacterRepository.findByCharacterName("須王御幸");
			StoryEntity miyukiStory = storyRepository.findByUserIdAndRomanceCharacterId(saveEntity.getUserId(), miyukiEntity);
			Integer miyukiChapterNumber = miyukiStory.getChapterNumber();
			
			RomanceCharacterEntity takutoEntity = romanceCharacterRepository.findByCharacterName("園山巧斗");
			StoryEntity takutoStory = storyRepository.findByUserIdAndRomanceCharacterId(saveEntity.getUserId(), takutoEntity);
			Integer takutoChapterNumber = takutoStory.getChapterNumber();
			
			RomanceCharacterEntity miruEntity = romanceCharacterRepository.findByCharacterName("相良実瑠");
			StoryEntity miruStory = storyRepository.findByUserIdAndRomanceCharacterId(saveEntity.getUserId(), miruEntity);
			Integer miruChapterNumber = miruStory.getChapterNumber();
			
			// 保存
			savedCharacterStoryRepository.save(new SavedCharacterStoryEntity(takumiChapterNumber, saveEntity, takumiEntity));
			savedCharacterStoryRepository.save(new SavedCharacterStoryEntity(somaChapterNumber, saveEntity, somaEntity));
			savedCharacterStoryRepository.save(new SavedCharacterStoryEntity(miyukiChapterNumber, saveEntity, miyukiEntity));
			savedCharacterStoryRepository.save(new SavedCharacterStoryEntity(takutoChapterNumber, saveEntity, takutoEntity));
			savedCharacterStoryRepository.save(new SavedCharacterStoryEntity(miruChapterNumber, saveEntity, miruEntity));
			
		} catch(Exception e) {
			throw new RuntimeException("キャラクターストーリーのセーブに失敗しました", e);
			
		}
		
		return "ok";
		
	}
	
	/**
	 * メインストーリーセーブ機能
	 * @param saveEntity
	 * @return
	 */
	public String saveMainStory(SaveEntity saveEntity) {
		
		if(saveEntity == null || saveEntity.getUserId() == null) {
			throw new RuntimeException("saveEntityが空のためメインストーリーが保存できませんでした。");
			
		}
		
		try {
			RomanceCharacterEntity mainEntity = romanceCharacterRepository.findByCharacterName("メイン");
			StoryEntity mainStory = storyRepository.findByUserIdAndRomanceCharacterId(saveEntity.getUserId(), mainEntity);
			Integer mainChapterNumber = mainStory.getChapterNumber();
			
			savedMainStoryRepository.save(new SavedMainStoryEntity(mainChapterNumber, saveEntity));
			
		} catch(Exception e) {
			throw new RuntimeException("メインストーリーのセーブに失敗しました。", e);
			
		}
		
		return "ok";
		
	}
	
	/**
	 * 更新用キャラクターストーリーセーブ機能
	 * @param session
	 * @param saveEntity
	 * @return
	 */
	public String updateCharacterStory(SaveEntity saveEntity) {
		// 各所で使うユーザー情報取得
		UsersEntity userEntity = saveEntity.getUserId();
		
		if(saveEntity == null || saveEntity.getSaveId() == null) {
			throw new RuntimeException("saveEntityが空なのでストーリーを保存できません");
			
		}
		
		try {
			// キャラクターEntity取得
			RomanceCharacterEntity takumiEntity = romanceCharacterRepository.findByCharacterName("園山巧美");
			// userEntityが紐づいているキャラクターのStoryEntityからチャプター番号を取得
			StoryEntity takumiStoryEntity = storyRepository.findByUserIdAndRomanceCharacterId(userEntity, takumiEntity);
			Integer takumiChapter = takumiStoryEntity.getChapterNumber();
			// セーブEntityから各キャラクターのseveEntity取得
			SavedCharacterStoryEntity takumiSaveEntity = savedCharacterStoryRepository.findBySaveIdAndRomanceCharacterId(saveEntity, takumiEntity);
			// userEntityがもっているチャプター番号をセット
			takumiSaveEntity.setChapterNumber(takumiChapter);
			
			RomanceCharacterEntity somaEntity = romanceCharacterRepository.findByCharacterName("小早川颯真");
			StoryEntity somaStoryEntity = storyRepository.findByUserIdAndRomanceCharacterId(userEntity, somaEntity);
			Integer somaChapter = somaStoryEntity.getChapterNumber();
			SavedCharacterStoryEntity somaSaveEntity = savedCharacterStoryRepository.findBySaveIdAndRomanceCharacterId(saveEntity, somaEntity);
			somaSaveEntity.setChapterNumber(somaChapter);
			
			RomanceCharacterEntity miyukiEntity = romanceCharacterRepository.findByCharacterName("須王御幸");
			StoryEntity miyukiStoryEntity = storyRepository.findByUserIdAndRomanceCharacterId(userEntity, miyukiEntity);
			Integer miyukiChapter = miyukiStoryEntity.getChapterNumber();
			SavedCharacterStoryEntity miyukiSaveEntity = savedCharacterStoryRepository.findBySaveIdAndRomanceCharacterId(saveEntity, miyukiEntity);
			miyukiSaveEntity.setChapterNumber(miyukiChapter);
			
			RomanceCharacterEntity takutoEntity = romanceCharacterRepository.findByCharacterName("園山巧斗");
			StoryEntity takutoStoryEntity = storyRepository.findByUserIdAndRomanceCharacterId(userEntity, takutoEntity);
			Integer takutoChapter = takutoStoryEntity.getChapterNumber();
			SavedCharacterStoryEntity takutoSaveEntity = savedCharacterStoryRepository.findBySaveIdAndRomanceCharacterId(saveEntity, takutoEntity);
			takutoSaveEntity.setChapterNumber(takutoChapter);
			
			RomanceCharacterEntity miruEntity = romanceCharacterRepository.findByCharacterName("相良実瑠");
			StoryEntity miruStoryEntity = storyRepository.findByUserIdAndRomanceCharacterId(userEntity, miruEntity);
			Integer miruChapter = miruStoryEntity.getChapterNumber();
			SavedCharacterStoryEntity miruSaveEntity = savedCharacterStoryRepository.findBySaveIdAndRomanceCharacterId(saveEntity, miruEntity);
			miruSaveEntity.setChapterNumber(miruChapter);
			
			// 保存
			savedCharacterStoryRepository.save(takumiSaveEntity);
			savedCharacterStoryRepository.save(somaSaveEntity);
			savedCharacterStoryRepository.save(miyukiSaveEntity);
			savedCharacterStoryRepository.save(takutoSaveEntity);
			savedCharacterStoryRepository.save(miruSaveEntity);
			
		} catch(Exception e) {
			throw new RuntimeException("キャラクターストーリーのセーブに失敗しました", e);
			
		}
		
		return "ok";
		
	}
	
	/**
	 * 更新用メインストーリーセーブ機能
	 * @param saveEntity
	 * @return
	 */
	public String updateMainStory(SaveEntity saveEntity) {
		
		if(saveEntity == null || saveEntity.getUserId() == null) {
			throw new RuntimeException("saveEntityが空のためメインストーリーが保存できませんでした。");
			
		}
		
		// 各種情報取得
		RomanceCharacterEntity mainEntity = romanceCharacterRepository.findByCharacterName("メイン");
		UsersEntity userEntity = saveEntity.getUserId();
		StoryEntity mainStoryEntity = storyRepository.findByUserIdAndRomanceCharacterId(userEntity, mainEntity);
		
		try {
			// userEntityが紐づいているキャラクターのStoryEntityからチャプター番号を取得
			Integer mainChapter = mainStoryEntity.getChapterNumber();
			// セーブEntityから各キャラクターのseveEntity取得
			SavedMainStoryEntity mainSaveEntity = savedMainStoryRepository.findBySaveId(saveEntity);
			// userEntityがもっているチャプター番号をセット
			mainSaveEntity.setChapterNumber(mainChapter);
			// 格納後保存
			savedMainStoryRepository.save(mainSaveEntity);
			
		} catch(Exception e) {
			throw new RuntimeException("メインストーリーのセーブに失敗しました。", e);
			
		}
		
		return "ok";
		
	}

}
