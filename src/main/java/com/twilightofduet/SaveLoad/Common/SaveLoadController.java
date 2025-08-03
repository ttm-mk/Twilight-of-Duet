package com.twilightofduet.SaveLoad.Common;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.twilightofduet.SaveLoad.SaveFunction.SaveEntity;
import com.twilightofduet.SaveLoad.SaveFunction.SaveLoadService;
import com.twilightofduet.SaveLoad.SaveFunction.SaveRepository;
import com.twilightofduet.SaveLoad.SaveStory.main.SavedMainStoryEntity;
import com.twilightofduet.SaveLoad.SaveStory.main.SavedMainStoryRepository;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * SaveLoadController
 * 作成者 tsutsumi miki
 * 編集日 2025/8/1 tsutsumi miki
 */

@Controller
public class SaveLoadController {
	
	@Autowired
	SaveLoadService saveLoadService;
	@Autowired
	SavedMainStoryRepository savedMainStoryRepository;
	@Autowired
	SaveRepository saveRepository;
	@Autowired
	UsersRepository userRepository;
	@Autowired
	SaveLoadCheck saveLoadCheck;
	
	/**
	 * セーブ画面の表示
	 * @return
	 */
	@GetMapping("/save")
	public String saveDisplay(HttpSession session, Model model) {
		// ユーザー情報の取得
		Integer userId = (Integer)session.getAttribute("userId");
		UsersEntity userEntity = userRepository.findByUserId(userId);
		
		//saveEntityを取得する
		SaveEntity saveEntityOne = saveRepository.findByUserIdAndSlotNumber(userEntity, 1);
		SaveEntity saveEntityTwo = saveRepository.findByUserIdAndSlotNumber(userEntity, 2);

		// saveBeanを作成
		SaveBean saveBeanOne = new SaveBean();
		SaveBean saveBeanTwo = new SaveBean();
		
		if(saveEntityOne != null) {
			// スロットナンバー１のデータ格納:TODO：これ格納用のメソッド作ってまとめたほうがいい気がするな
			saveBeanOne.setSlotNumber(saveEntityOne.getSlotNumber());
			SavedMainStoryEntity saveMainOneEntity = savedMainStoryRepository.findBySaveId(saveEntityOne);
			saveBeanOne.setMainStoryChapter(saveMainOneEntity.getChapterNumber());
			saveBeanOne.setCreateDate(saveEntityOne.getCreatedDate());
			model.addAttribute("saveOne", saveBeanOne);
			
		} else {
			model.addAttribute("saveOne", saveBeanOne);
			
		}
		
		if(saveEntityTwo != null) {
		// スロットナンバー2のデータ格納
			saveBeanTwo.setSlotNumber(saveEntityTwo.getSlotNumber());
			SavedMainStoryEntity saveMainTwoEntity = savedMainStoryRepository.findBySaveId(saveEntityTwo);
			saveBeanTwo.setMainStoryChapter(saveMainTwoEntity.getChapterNumber());
			saveBeanTwo.setCreateDate(saveEntityTwo.getCreatedDate());
			model.addAttribute("saveTwo", saveBeanTwo);

		} else {
			model.addAttribute("saveTwo", saveBeanTwo);

		}
		
		return "saveLoad/save.html";

	}
	
	/**
	 * ロード画面の表示
	 * @return
	 */
	@GetMapping("/load")
	public String loadDisplay() {
		return "saveLoad/load.html";
	}
	
	/**
	 * セーブ機能実施
	 * @param session　セッション情報
	 * @return
	 */
	@PostMapping("/save/ok")
	public String saveAction(@RequestParam("slotNumber") Integer slotNumber, HttpSession session, Model model) {

		String result = saveLoadCheck.saveCheck(session, slotNumber);
		
		// で、最後にセーブしたメッセージを格納し表示させるように設定
		model.addAttribute("message", result);
		// で、以下画面に返したらいいのかなと思う
		// TODO:画面に変わったときにデータも更新して画面表示させたい。リダイレクトでいいのかどうなのか一回調べること
		
		return "saveLoad/save.html";
		
	}

}
