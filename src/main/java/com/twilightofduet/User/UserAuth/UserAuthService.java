package com.twilightofduet.User.UserAuth;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.twilightofduet.User.UserCommon.UserDTO;
import com.twilightofduet.User.UserCommon.UserForm;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * UserAuthService
 * 作成者 tsutsumi miki
 * 編集日 2025/3/15 tsutsumi miki
 */

@Service
public class UserAuthService {
	@Autowired
	UsersRepository userRepository;
	
	@PostMapping("/relogin")
	public UserDTO userNewCreate(UserForm userForm) {
		//ユーザー情報の登録
		UsersEntity user = new UsersEntity();
		BeanUtils.copyProperties(userForm, user, "user_id");
		user = userRepository.save(user);
		
		// UserDTOにユーザー情報を格納
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(user.getUserName());
		userDTO.setUserPassword(user.getUserPassword());
		
		return userDTO;
		
	}

}
