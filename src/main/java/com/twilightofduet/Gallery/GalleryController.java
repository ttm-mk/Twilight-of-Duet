package com.twilightofduet.Gallery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * GalleryController
 * 作成者 tsutsumi miki
 * 編集日 2025/1/11 tsutsumi miki
 */

@Controller
public class GalleryController {
	
	/**
	 * ギャラリーのトップ画面/メインギャラリー
	 */
	@GetMapping("/gallery")
	public String GalleryTopDisplay() {
		return "gallery/gallery_all";
		
	}

}
