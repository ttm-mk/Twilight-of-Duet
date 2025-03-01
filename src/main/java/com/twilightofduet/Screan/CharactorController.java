package com.twilightofduet.Screan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * CharactorController
 * 作成者 tsutsumi miki
 * 編集日 2025/1/5 tsutsumi miki
 */

@Controller
public class CharactorController {
	
	/**
	 * 最初に表示されるキャラクター紹介画面
	 * @return
	 */
	@GetMapping("/charactor")
	public String charactorTopDisplay() {
		return "charactor/narumi_chiharu";
	}
	
	/**
	 * 園山　巧美の紹介画面
	 * @return
	 */
	@GetMapping("/charactor/SonoyamaTakumi")
	public String charactorTakumiDisplay() {
		return "charactor/sonoyama_takumi";
	}

	/**
	 * 小早川　颯真の紹介画面
	 * @return
	 */
	@GetMapping("/charactor/KobayakawaSoma")
	public String charactorSomaDisplay() {
		return "charactor/kobayakawa_soma";
	}
	
	/**
	 * 須王　御幸の紹介画面
	 * @return
	 */
	@GetMapping("/charactor/SuoMiyuki")
	public String charactorMiyukiDisplay() {
		return "charactor/suo_miyuki";
	}
	
	/**
	 * 園山　巧斗の紹介画面
	 * @return
	 */
	@GetMapping("/charactor/SonoyamaTakuto")
	public String charactorTakutoDisplay() {
		return "charactor/sonoyama_takuto";
	}
	
	/**
	 * 相良　実瑠の紹介画面
	 * @return
	 */
	@GetMapping("/charactor/AiraMiru")
	public String charactorMiruDisplay() {
		return "charactor/aira_miru";
	}
	
}
