package com.twilightofduet.User.UserCommon;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.twilightofduet.User.UserAuth.UserAuthService;

/*
 * InquiryController
 * 作成者 tsutsumi miki
 * 編集日 2025/３/22 tsutsumi miki
 */

@Controller
public class UserController {
	
	@Autowired
	UsersRepository userRepository;
	@Autowired
	UserAuthService userAuthService;
	
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
	 * ユーザー情報画面表示
	 * 
	 * @param session　セッション情報
	 * @param model　モデル
	 * @return　ユーザー情報画面
	 */
	@GetMapping("/user")
	public String userDisplay(HttpSession session, Model model) {
		// Bean作成しセッション情報を取得して格納する
		UsersBean userBean = new UsersBean();
		userBean = userAuthService.getUserSessionInformation(session);
		// モデルにBeanからコピーして格納
		model.addAttribute("user", userBean);
		
		return "/user/user_information";
	}
	
	/**
	 * ユーザー情報編集
	 * @return　ユーザー情報編集画面
	 */
	@GetMapping("/user/edit")
	public String userEditDisplay(HttpSession session, Model model) {
		// Bean作成しセッション情報を取得して格納する
		UsersBean userBean = new UsersBean();
		userBean = userAuthService.getUserSessionInformation(session);
		// モデルにBeanからコピーして格納
		model.addAttribute("user", userBean);
		
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
