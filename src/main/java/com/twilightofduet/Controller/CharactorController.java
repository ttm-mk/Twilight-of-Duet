package com.twilightofduet.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * IndexController
 * 作成者 tsutsumi miki
 * 編集日 2025/1/5 tsutsumi miki
 */

@Controller
public class CharactorController {
	
	@GetMapping("/charactor")
	public String charactorTopDisplay() {
		return "charactor/narumi_chiharu";
	}
	
	@GetMapping("/charactor/SonoyamaTakumi")
	public String charactorTakumiDisplay() {
		return "charactor/sonoyama_takumi";
	}

	@GetMapping("/charactor/KobayakawaSoma")
	public String charactorSomaDisplay() {
		return "charactor/kobayakawa_soma";
	}
	
	@GetMapping("/charactor/SuoMiyuki")
	public String charactorMiyukiDisplay() {
		return "charactor/suo_miyuki";
	}
	
	@GetMapping("/charactor/SonoyamaTakuto")
	public String charactorTakutoDisplay() {
		return "charactor/sonoyama_takuto";
	}
	
	@GetMapping("/charactor/AiraMiru")
	public String charactorMiruDisplay() {
		return "charactor/aira_miru";
	}
	
}
