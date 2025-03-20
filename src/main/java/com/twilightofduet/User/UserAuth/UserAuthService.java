package com.twilightofduet.User.UserAuth;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.twilightofduet.Gallery.GalleryEntity;
import com.twilightofduet.Gallery.GalleryService;
import com.twilightofduet.Likeability.LikeabilityEntity;
import com.twilightofduet.Likeability.LikeabilityService;
import com.twilightofduet.Story.StoryEntity;
import com.twilightofduet.Story.StoryService;
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
	private LikeabilityService likeabilityService;
	private StoryService storyService;
	private GalleryService galleryService;
	
	
	@PostMapping("/relogin")
	public UserDTO userNewCreate(UserForm userForm) {
		//ユーザー情報の登録
		UsersEntity user = new UsersEntity();
		BeanUtils.copyProperties(userForm, user, "user_id");
		
		// 好感度FKの取得
		LikeabilityEntity likeabilityEntity = likeabilityService.likeabilityCreate();
		user.setLikeabilityId(likeabilityEntity);
		user = userRepository.save(user);
		
		// ストーリーFKの取得
		StoryEntity storyEntity = storyService.storyCreate();
		user.setStoryId(storyEntity);
		user = userRepository.save(user);
		
		// ギャラリーFKの取得
		GalleryEntity galleryEntity = galleryService.galleryCreate();
		user.setGalleryId(galleryEntity);
		user = userRepository.save(user);
		
		
		// UserDTOにユーザー情報を格納
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(user.getUserName());
		userDTO.setUserPassword(user.getUserPassword());
		
		return userDTO;
		
	}

}
