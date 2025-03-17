package com.twilightofduet.User.UserAuth;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.twilightofduet.Likeability.LikeabilityEntity;
import com.twilightofduet.Likeability.LikeabilityService;
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
	
	@Autowired
	private LikeabilityService likeabilityService;
	
	@PostMapping("/relogin")
	public UserDTO userNewCreate(UserForm userForm) {
		//ユーザー情報の登録
		UsersEntity user = new UsersEntity();
		BeanUtils.copyProperties(userForm, user, "user_id");
		
		// 好感度PKの取得
		LikeabilityEntity likeabilityEntity = likeabilityService.likeabilityCreate();
		user.setLikeabilityId(likeabilityEntity);
		user = userRepository.save(user);
		
		// ストーリーPKの取得
		
		
		// ギャラリーPKの取得
		
		
		
		// UserDTOにユーザー情報を格納
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(user.getUserName());
		userDTO.setUserPassword(user.getUserPassword());
		
		return userDTO;
		
	}

}
