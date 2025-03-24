package com.twilightofduet.User.UserInformation;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.twilightofduet.User.UserCommon.UserForm;
import com.twilightofduet.User.UserCommon.UsersBean;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * UserInformationService
 * 作成者 tsutsumi miki
 * 編集日 2025/3/24 tsutsumi miki
 */

@Service
public class UserInformationService {
	
	@Autowired
	UsersRepository userRepository;
	
	/**
	 * ユーザー情報編集処理実行
	 * 
	 * @param userForm　ユーザーフォーム
	 * @param model　モデル
	 * @param session　セッション情報
	 * @return　userInformationCompleteメソッドに結果を戻す
	 */
	@PostMapping("/user/edit/information")
	public UsersBean userInformationEdit(UserForm userForm, Model model, HttpSession session) {
		// セッション情報からID検索して取得
		Integer userId = (Integer) session.getAttribute("userId");
		// エンティティに検索結果を格納
		UsersEntity userEntity = new UsersEntity();
		userEntity = userRepository.findByUserId(userId);
		// ID以外のフォーム情報をエンティティにコピー（上書き）
		BeanUtils.copyProperties(userForm, userEntity, "user_id");
		// 情報の保存
		userRepository.save(userEntity);
		// Beanに結果を格納
		UsersBean userBean = new UsersBean();
		BeanUtils.copyProperties(userEntity, userBean);
		
		return userBean;
	}

}
