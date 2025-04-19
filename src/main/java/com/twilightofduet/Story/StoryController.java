package com.twilightofduet.Story;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  StoryController
 * 作成者 tsutsumi miki
 * 編集日 2025/4/20 tsutsumi miki
 */

@Controller
public class StoryController {
	
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
	public String StoryMain1() {
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
