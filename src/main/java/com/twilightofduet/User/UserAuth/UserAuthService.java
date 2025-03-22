package com.twilightofduet.User.UserAuth;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.twilightofduet.Common.LoginForm;
import com.twilightofduet.Gallery.GalleryService;
import com.twilightofduet.Likeability.LikeabilityService;
import com.twilightofduet.Story.StoryService;
import com.twilightofduet.User.UserCommon.UserDTO;
import com.twilightofduet.User.UserCommon.UserForm;
import com.twilightofduet.User.UserCommon.UserServiceCheck;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * UserAuthService
 * 作成者 tsutsumi miki
 * 編集日 2025/3/22 tsutsumi miki
 */

@Service
public class UserAuthService {
	@Autowired
	UsersRepository userRepository;
	@Autowired
	private LikeabilityService likeabilityService;
	@Autowired
	private StoryService storyService;
	@Autowired
	private GalleryService galleryService;
	@Autowired
	UserServiceCheck userServiceCheck;
	
	/**
	 * User新規登録機能
	 * 
	 * @param userForm 画面で取得したUser情報
	 * @return　userDTO　ユーザー情報を返す用の箱
	 */
	@PostMapping("/relogin")
	public UserDTO userNewCreate(UserForm userForm) {
		
		//ユーザー情報をEntityにコピーと必要情報の格納
		UsersEntity user = new UsersEntity();
		BeanUtils.copyProperties(userForm, user, "user_id");
		user.setHeroineName("鳴海千晴");
		user.setHeroineNickname("ちい");
		
		// 好感度FKの取得
		user.setLikeabilityId(likeabilityService.likeabilityCreate());
		
		// ストーリーFKの取得
		user.setStoryId(storyService.storyCreate());
		
		// ギャラリーFKの取得
		user.setGalleryId(galleryService.galleryCreate());
		
		// User保存
		user = userRepository.save(user);
		
		
		// UserDTOにユーザー情報を格納
		UserDTO userDTO = new UserDTO();
		userDTO.setUserID(user.getUserId());
		userDTO.setUserName(user.getUserName());
		userDTO.setUserPassword(user.getUserPassword());
		
		return userDTO;
		
	}
	
	public Boolean userLoginCheck(LoginForm loginForm) {
		
		if(userRepository.findByUserNameAndUserPassword(loginForm.getUserName(), loginForm.getUserPassword()) == null) {
			
			return false;
			
		}else {
			
			return true;
		}
	}

}
