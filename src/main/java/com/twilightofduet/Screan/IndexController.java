package com.twilightofduet.Screan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * IndexController
 * 作成者 tsutsumi miki
 * 編集日 2024/12/24 tsutsumi miki
 */

@Controller
public class IndexController {
	
	@GetMapping("/top")
	public String topDisplay() {
		return "top";
	}

}
