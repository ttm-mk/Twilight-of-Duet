package com.twilightofduet.Story;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.twilightofduet.User.UserAuth.UserAuthService;
import com.twilightofduet.User.UserCommon.UsersBean;

/**
 *  StoryController
 * 作成者 tsutsumi miki
 * 編集日 2025/4/20 tsutsumi miki
 */

@Controller
public class StoryController {
	
	@Autowired
	UserAuthService userAuthService;
	
	/**
	 * ストーリートップ画面
	 * @return
	 */
	@GetMapping("/story")
	public String StoryTopDisplay() {
		return "story/story.html";
	}
	
	/**
	 * メインストーリー1話
	 * @return
	 */
	@GetMapping("/story/main/1")
	public String StoryMain1(HttpSession session, Model model) {
		// Bean作成しセッション情報を取得して格納する
		UsersBean userBean = userAuthService.getUserSessionInformation(session);
		// ユーザーIDをモデルに追加
	    model.addAttribute("userId", userBean.getUserId());
		
		return "story/charactor/main/story_main1.html";
	}
	
	/**
	 * キャラクターストーリー巧美1話
	 * @return
	 */
	@GetMapping("/story/SonoyamaTakumi/1")
	public String StoryTakumi1( ) {
		return "story/charactor/sonoyama_takumi/story_takumi1.html";
	}

}
