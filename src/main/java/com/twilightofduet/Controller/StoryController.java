package com.twilightofduet.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  IndexController
 * 作成者 tsutsumi miki
 * 編集日 2025/1/8 tsutsumi miki
 */

@Controller
public class StoryController {
	
	@GetMapping("/story/SonoyamaTakumi/1")
	public String StoryTakumi1( ) {
		return "story/sonoyama_takumi/story_takumi1";
	}

}
