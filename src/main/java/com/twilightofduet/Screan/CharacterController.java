package com.twilightofduet.Screan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * characterController
 * 作成者 tsutsumi miki
 * 編集日 2025/1/5 tsutsumi miki
 */

@Controller
public class CharacterController {
	
	/**
	 * 最初に表示されるキャラクター紹介画面
	 * @return
	 */
	@GetMapping("/character")
	public String characterTopDisplay() {
		return "character/heroine";
	}
	
	/**
	 * 園山　巧美の紹介画面
	 * @return
	 */
	@GetMapping("/character/SonoyamaTakumi")
	public String characterTakumiDisplay() {
		return "character/sonoyama_takumi";
	}

	/**
	 * 小早川　颯真の紹介画面
	 * @return
	 */
	@GetMapping("/character/KobayakawaSoma")
	public String characterSomaDisplay() {
		return "character/kobayakawa_soma";
	}
	
	/**
	 * 須王　御幸の紹介画面
	 * @return
	 */
	@GetMapping("/character/SuoMiyuki")
	public String characterMiyukiDisplay() {
		return "character/suo_miyuki";
	}
	
	/**
	 * 園山　巧斗の紹介画面
	 * @return
	 */
	@GetMapping("/character/SonoyamaTakuto")
	public String characterTakutoDisplay() {
		return "character/sonoyama_takuto";
	}
	
	/**
	 * 相良　実瑠の紹介画面
	 * @return
	 */
	@GetMapping("/character/AiraMiru")
	public String characterMiruDisplay() {
		return "character/aira_miru";
	}
	
}
