package com.twilightofduet.User;

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
	 * ログイン画面表示
	 * @return
	 */
	@GetMapping("/login")
	public String userLogin() {
		return "/user/user_login";
	}
	
	/**
	 * ユーザー新規登録画面表示
	 * @return
	 */
	@GetMapping("/new")
	public String userNew() {
		return "/user/user_new";
	}
	
	/**
	 * ユーザー情報/トップ画面表示
	 * @return
	 */
	@GetMapping("/user")
	public String userDisplay() {
		return "/user/user_information";
	}
	
	/**
	 * ユーザー情報編集
	 * @return
	 */
	@GetMapping("/user/edit")
	public String userEditDisplay() {
		return "/user/user_edit";
	}
	
//	/**
//	 * 
//	 * @param redirectAttributes
//	 * @return
//	 */
//	@PostMapping("/user/edit/complete")
//	public String userEditCompleteDisplay(@ModelAttribute RedirectAttributes redirectAttributes) {
//		redirectAttributes.addFlashAttribute("message", "編集しました。");
//		return "redirect:/user/edit";
//	}

}
