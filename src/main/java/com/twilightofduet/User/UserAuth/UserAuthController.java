package com.twilightofduet.User.UserAuth;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.twilightofduet.User.UserCommon.UserDTO;
import com.twilightofduet.User.UserCommon.UserForm;
import com.twilightofduet.User.UserCommon.UsersBean;

/*
 * UserAuthController
 * 作成者 tsutsumi miki
 * 編集日 2025/3/15 tsutsumi miki
 */

@Controller
public class UserAuthController {
	
	private UserAuthService userAuthService;

	// コンストラクタです
	public UserAuthController(UserAuthService userAuthService) {
		this.userAuthService = userAuthService;
	}
	
	
	@PostMapping("/new/confirm")
	public String userNewConfirm(UserForm userForm, Model model) {
		UsersBean userBean = new UsersBean();
		BeanUtils.copyProperties(userForm, userBean);
		model.addAttribute("user", userBean);
		
		return "user/user_confirm.html";
	}
	
	@GetMapping("/relogin")
	public String userCreate(UserForm userForm, Model model) {
		// userDTOに登録結果を格納
		UserDTO userDTO = userAuthService.userNewCreate(userForm);
		
		// 表示するためにDTO⇒Beanに格納・表示
		UsersBean userBean = new UsersBean();
		BeanUtils.copyProperties(userDTO, userBean);
		model.addAttribute("user", userBean);
		
		return "user/user_login.html";
		
	}

}
