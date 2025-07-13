package com.twilightofduet.User.UserAuth;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.twilightofduet.Common.LoginForm;
import com.twilightofduet.User.UserCommon.UserDTO;
import com.twilightofduet.User.UserCommon.UserForm;
import com.twilightofduet.User.UserCommon.UserServiceCheck;
import com.twilightofduet.User.UserCommon.UsersBean;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * UserAuthController
 * 作成者 tsutsumi miki
 * 編集日 2025/7/2 tsutsumi miki
 */

@Controller
public class UserAuthController {
	@Autowired
	UserServiceCheck userServiceCheck;
	@Autowired
	UsersRepository userRepository;
	
	private UserAuthService userAuthService;

	// コンストラクタです
	public UserAuthController(UserAuthService userAuthService) {
		this.userAuthService = userAuthService;
	}
	
	/**
	 * 確認画面に遷移
	 * 
	 * @param userForm　ユーザーフォーム情報
	 * @param model　モデル
	 * @param redirectAttributes　リダイレクト用のモデル
	 * @return　True；確認画面　False：新規登録画面
	 */
	@PostMapping("/new/confirm")
	public String userNewConfirm(UserForm userForm, Model model, RedirectAttributes redirectAttributes) {
		// ユーザー名とパスワードの組み合わせチェック（同じのははじかれる）
		if (userServiceCheck.userInformationCheck(userForm)){
			redirectAttributes.addFlashAttribute("error", "このユーザー名とパスワードの組み合わせはすでに存在しています。変更して下さい。");

			return "redirect:/new";
			
		}
		
		// チェックに引っかからなかったものをBeanに格納
		UsersBean userBean = new UsersBean();
		UserDTO userDTO = userAuthService.userNewCreate(userForm);
		String password = userAuthService.changePassword(userDTO);
		BeanUtils.copyProperties(userForm, userBean);
		userBean.setUserPassword(password);
		model.addAttribute("user", userBean);
		
		return "user/user_confirm.html";
	}
	
	
	/**
	 * 
	 * 新規登録機能
	 * 
	 * @param userForm　ユーザー情報
	 * @param model　モデル
	 * @return　ログイン画面
	 */
	@GetMapping("/relogin")
	public String userCreate(UserForm userForm, Model model) {
		// userDTOに登録結果を格納
		UserDTO userDTO = userAuthService.userNewCreate(userForm);
		

		// 表示するためにDTO⇒Beanに格納・表示
		UsersBean userBean = new UsersBean();
		BeanUtils.copyProperties(userDTO, userBean);
		model.addAttribute("user", userBean);
		
		return "redirect:/login";
		
		
	}
	
	/**
	 * ユーザーログイン機能
	 * 
	 * @param loginForm　ログインフォーム情報
	 * @param session　セッション情報
	 * @param redirectAttributes　リダイレクト用
	 * @return　true:トップ画面、false:ログイン画面
	 */
	@PostMapping("/top")
	public String userLogin(LoginForm loginForm, HttpSession session, RedirectAttributes redirectAttributes) {
		// ユーザーIDの取得
		Integer userId = userAuthService.doGetUserId(loginForm);
		UsersEntity userEntity = userRepository.findByUserId(userId);
		// 取得したユーザーIDの確認：0の場合ログイン画面に戻す
		if(userId == 0 || userEntity.getDeletedFlag() == 1) {
			redirectAttributes.addFlashAttribute("error", "ログイン情報が正しくありません。");
			
			return "redirect:/login";
			
		}
		// ユーザーID取得成功した場合、セッション情報格納
		session.setAttribute("userId", userId);
		
		return "redirect:/";
		
	}
	
	/**
	 * 退会画面遷移
	 * 
	 * @param session　セッション情報
	 * @param model　モデル
	 * @return　退会画面
	 */
	@GetMapping("/user/delete")
	public String userDeleteConfirm(HttpSession session, Model model) {
		// ユーザーIDの取得
		// Bean作成しセッション情報を取得して格納する
		UsersBean userBean = userAuthService.getUserSessionInformation(session);	    
	    model.addAttribute("userId", userBean.getUserId());
		
		return "user/user_delete.html";
		
	}
	
	/**
	 * ユーザ―論理削除処理
	 * 
	 * @param session　セッション情報
	 * @return　トップ画面に遷移
	 */
	@PostMapping("/user/delete/complete")
	public String userDeleteComplete(HttpSession session) {
		// セッション情報取得
		String message =  userAuthService.userDeleted(session);
		System.out.println(message);
		
		return "redirect:/";
	}
	
	/**
	 * ログアウト機能
	 * 
	 * @param session　セッション情報
	 * @return　トップ画面
	 */
	@GetMapping("/logout")
	public String userLogout(HttpSession session) {
		// セッション情報の破棄
		session.invalidate();
		
		return "redirect:/";
		
	}


}
