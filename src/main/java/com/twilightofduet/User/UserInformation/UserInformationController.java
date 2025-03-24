package com.twilightofduet.User.UserInformation;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.twilightofduet.User.UserAuth.UserAuthService;
import com.twilightofduet.User.UserCommon.UserForm;
import com.twilightofduet.User.UserCommon.UsersBean;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * UserInformationController
 * 作成者 tsutsumi miki
 * 編集日 2025/3/24 tsutsumi miki
 */

@Controller
public class UserInformationController {
	
	@Autowired
	UsersRepository userRepository;
	@Autowired
	UserAuthService userAuthService;
	@Autowired
	UserInformationService userInformationService;
	
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
	 * ユーザー情報編集画面
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
	
	/**
	 * ユーザー情報編集処理
	 * 
	 * @param userForm　ユーザーフォーム
	 * @param model　モデル
	 * @param session　セッション情報
	 * @return　ユーザー情報編集画面
	 */
	@GetMapping("user/edit/complete")
	public String userEditComplete(UserForm userForm, Model model, HttpSession session) {
		
		UsersBean userBean = new UsersBean();
		// UserInformationEditメソッドに処理を回して結果をBeanに格納
		userBean = userInformationService.userInformationEdit(userForm, model, session);
		// Beanの情報を画面に渡す
		model.addAttribute("user", userBean);
		// 編集メッセージを画面に渡す
		model.addAttribute("message", "編集しました。");
		
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
