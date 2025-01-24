package com.twilightofduet.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * InquiryController
 * 作成者 tsutsumi miki
 * 編集日 2025/1/24 tsutsumi miki
 */

@Controller
public class UserController {
	
	/**
	 * ユーザー情報/トップ画面表示
	 * @return
	 */
	@GetMapping("/user")
	public String userDisplay() {
		return "/user/user_information";
	}

}
