package com.twilightofduet.SaveLoad.Common;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilightofduet.SaveLoad.SaveFunction.SaveEntity;
import com.twilightofduet.SaveLoad.SaveFunction.SaveLoadService;
import com.twilightofduet.SaveLoad.SaveFunction.SaveRepository;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * SaveLoadCheck
 * 作成者 tsutsumi miki
 * 編集日 2025/8/6 tsutsumi miki
 */

@Service
public class SaveLoadCheck {
	
	@Autowired
	SaveRepository saveRepository;
	@Autowired
	UsersRepository userRepository;
	@Autowired
	SaveLoadService saveLoadService;
	
	/**
	 * セーブ分岐用
	 * @param session
	 * @param slotNumber
	 * @return
	 */
	public String saveCheck(HttpSession session, Integer slotNumber) {
		
		Integer userId = (Integer)session.getAttribute("userId");
		UsersEntity userEntity = userRepository.findByUserId(userId);
		SaveEntity saveEntity = saveRepository.findByUserIdAndSlotNumber(userEntity, slotNumber);
		
		try {
			// セーブEntityがNULLじゃないとき
			if(saveEntity != null) {
				saveEntity = saveLoadService.updateSlot(saveEntity);
				
			}
			
			// セーブEntityがNULLのとき
			if(saveEntity == null) {
				SaveEntity newSaveEntity = saveLoadService.saveSlot(session, slotNumber);
				
			}
			
			return "セーブしました。";
			
		} catch(Exception e) {
			throw new RuntimeException("セーブに失敗しました", e);
			
		}
		
		
	}
	
	public String loadCheck(HttpSession session, Integer slotNumber) {
		// userEntityとsaveEntityの取得
		Integer userId = (Integer)session.getAttribute("userId");
		UsersEntity userEntity = userRepository.findByUserId(userId);
		SaveEntity saveEntity = saveRepository.findByUserIdAndSlotNumber(userEntity, slotNumber);
		
		try {
			// セーブEntityがNULLじゃないか確認
			if(saveEntity != null) {
				saveEntity = saveLoadService.uploadSlot(saveEntity);
				
			}
			
			return "ロードしました。";
			
		} catch(Exception e) {
			throw new RuntimeException("ロードに失敗しました", e);
			
		}
		
		
	}

}
