package com.twilightofduet.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * IndexController
 * 作成者 tsutsumi miki
 * 編集日 2025/1/19 tsutsumi miki
 */

@Controller
public class InquiryController {
	
	@GetMapping("/inquiry")
	public String inquiryDisplay() {
		return "/inquiry";
	}

}
