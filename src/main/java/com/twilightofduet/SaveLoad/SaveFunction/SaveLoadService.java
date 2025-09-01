package com.twilightofduet.SaveLoad.SaveFunction;

import java.util.Date;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilightofduet.SaveLoad.Common.SaveBean;
import com.twilightofduet.SaveLoad.SaveLikeability.SavedLikeabilityService;
import com.twilightofduet.SaveLoad.SaveStory.SavedStoryService;
import com.twilightofduet.SaveLoad.SaveStory.main.SavedMainStoryEntity;
import com.twilightofduet.SaveLoad.SaveStory.main.SavedMainStoryRepository;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/**
 * SaveLoadServiceコントローラ
 * 作成者 tsutsumi miki
 * 編集日 2025/9/2 tsutsumi miki
 */

@Service
public class SaveLoadService {
	
	@Autowired
	SaveRepository saveRepository;
	@Autowired
	UsersRepository userRepository;
	@Autowired
	SavedLikeabilityService savedLikeabilityService;
	@Autowired
	SavedStoryService savedStoryService;
	@Autowired
	SavedMainStoryRepository savedMainStoryRepository;
	
	/**
	 * セーブ機能
	 * @param session
	 * @param slotNumber
	 * @return saveEntity
	 */
	public SaveEntity saveSlot(HttpSession session, Integer slotNumber) {
		
		// 先にセーブだった
		SaveEntity saveEntity = new SaveEntity();
		
		try{
			UsersEntity userEntity = userRepository.findByUserId((Integer)session.getAttribute("userId"));
			saveEntity.setSlotNumber(slotNumber);
			saveEntity.setUserId(userEntity);
			saveRepository.save(saveEntity);
			
		} catch(Exception e) {
			throw new RuntimeException("セーブに失敗しました。:saveEntity", e);
			
		}
		// 次に現在の好感度をセーブしよう
		String resultLikeability = savedLikeabilityService.saveLikeability(saveEntity);
		// 次に現在のストーリーをセーブしよう
		String resultCharacterStory = savedStoryService.saveCharacterStory(saveEntity);
		String resultMainStory = savedStoryService.saveMainStory(saveEntity);

		if(resultLikeability.equals("ok") && resultCharacterStory.equals("ok") && resultMainStory.equals("ok")) {
			
			return saveEntity;
			
		} else {
			throw new RuntimeException("セーブに失敗しました。:resultEntity");
			// ここ、うまく処理させる。失敗したので各所セーブしたものを削除するとか処理させたい
			// ついでに投げて受け取る場所つくらないといけないね：TODO
		}
		
	}
	
	/**
	 * セーブ更新機能
	 * @param saveEntity
	 * @return
	 */
	public SaveEntity updateSlot(SaveEntity saveEntity) {
	
		// 次に現在の好感度をセーブしよう
		String resultLikeability = savedLikeabilityService.updateLikeability(saveEntity);
		// 次に現在のストーリーをセーブしよう
		String resultCharacterStory = savedStoryService.updateCharacterStory(saveEntity);
		String resultMainStory = savedStoryService.updateMainStory(saveEntity);


		if(resultLikeability.equals("ok") && resultCharacterStory.equals("ok") && resultMainStory.equals("ok")) {
			saveEntity.setUpdatedDate(new Date());
			saveEntity = saveRepository.save(saveEntity);
			return saveEntity;
			
		} else {
			throw new RuntimeException("セーブに失敗しました。:resultEntity");
			// ここ、うまく処理させる。失敗したので各所セーブしたものを削除するとか処理させたい
			// ついでに投げて受け取る場所つくらないといけないね：TODO
		}

	}
	
	/**
	 * ロード機能
	 * @param saveEntity
	 * @return
	 */
	public SaveEntity uploadSlot(SaveEntity saveEntity) {
		
		// 好感度を更新
		String resultLikeability = savedLikeabilityService.uploadLikeability(saveEntity);
		// ストーリーを更新　TODO:ロード機能作成
		String resultCharacterStory = savedStoryService.uploadCharacterStory(saveEntity);
		String resultMainStory = savedStoryService.uploadMainStory(saveEntity);
		
		if(resultLikeability.equals("ok") && resultCharacterStory.equals("ok") && resultMainStory.equals("ok")) {
			
			return saveEntity;
			
		} else {
			throw new RuntimeException("ロードに失敗しました。:resultEntity");
			// ここ、うまく処理させる。失敗したので各所セーブしたものを削除するとか処理させたい
			// ついでに投げて受け取る場所つくらないといけないね：TODO
		}
		
	}
	
	/**
	 * スロットナンバー1のデータを返す
	 * @param session
	 * @return saveBean
	 */
	public SaveBean getUserSlotNumberOne(HttpSession session) {
		// ユーザーIDの取得
		Integer userId = (Integer)session.getAttribute("userId");
		UsersEntity userEntity = userRepository.findByUserId(userId);
		// セーブEntityの取得
		SaveEntity saveEntity = saveRepository.findByUserIdAndSlotNumber(userEntity, 1);
		// スロットナンバー１をBeanに格納して返す
		SaveBean saveBeanOne = new SaveBean();
		saveBeanOne.setSaveId(saveEntity.getSaveId());
		saveBeanOne.setSlotNumber(saveEntity.getSlotNumber());
		SavedMainStoryEntity mainEntity = savedMainStoryRepository.findBySaveId(saveEntity);
		Integer mainStoryChapter = mainEntity.getChapterNumber();
		saveBeanOne.setMainStoryChapter(mainStoryChapter);
				
		return saveBeanOne;
	}
	
	/**
	 * スロットナンバー2のデータを返す
	 * @param session
	 * @return saveBean
	 */
	public SaveBean getUserSlotNumberTwo(HttpSession session) {
		// ユーザーIDの取得
		Integer userId = (Integer)session.getAttribute("userId");
		UsersEntity userEntity = userRepository.findByUserId(userId);
		// セーブEntityの取得
		SaveEntity saveEntity = saveRepository.findByUserIdAndSlotNumber(userEntity, 2);
		// スロットナンバー2をBeanに格納して返す
		SaveBean saveBeanTwo = new SaveBean();
		saveBeanTwo.setSaveId(saveEntity.getSaveId());
		saveBeanTwo.setSlotNumber(saveEntity.getSlotNumber());
		SavedMainStoryEntity mainEntity = savedMainStoryRepository.findBySaveId(saveEntity);
		Integer mainStoryChapter = mainEntity.getChapterNumber();
		saveBeanTwo.setMainStoryChapter(mainStoryChapter);
				
		return saveBeanTwo;
	}

}
