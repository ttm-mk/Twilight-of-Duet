package com.twilightofduet.User.UserAuth;

import java.util.Optional;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

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
import com.twilightofduet.User.UserCommon.UsersBean;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * UserAuthService
 * 作成者 tsutsumi miki
 * 編集日 2025/5/18 tsutsumi miki
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
	@Transactional
	@PostMapping("/relogin")
	public UserDTO userNewCreate(UserForm userForm) {
		
		//ユーザー情報をEntityにコピーと必要情報の格納
		UsersEntity user = new UsersEntity();
		BeanUtils.copyProperties(userForm, user, "user_id");
		user.setHeroineName("鳴海千晴");
		user.setHeroineNickname("ちい");
		user.setDeletedFlag(0);
		// User保存
		user = userRepository.save(user);
		
		if(user!= null) {
			
			// 好感度作成
			likeabilityService.likeabilityCreate(user);
			
			// ストーリー作成
			storyService.storyCreate(user);
			
			// ギャラリー作成
			galleryService.galleryCreate(user);
			
		}
		
		
		// UserDTOにユーザー情報を格納
		UserDTO userDTO = new UserDTO();
		userDTO.setUserID(user.getUserId());
		userDTO.setUserName(user.getUserName());
		userDTO.setUserPassword(user.getUserPassword());
		
		return userDTO;
		
	}
	
	
	/**
	 * ログイン情報からユーザー情報捜索機能
	 * 
	 * @param loginForm　ログインフォーム
	 * @return　true:捜索したユーザーID、false:0
	 */
	public Integer doGetUserId(LoginForm loginForm) {
		// ユーザー方法が存在するか検索
		Optional<UsersEntity> userEntity = userRepository.findByUserNameAndUserPassword(loginForm.getUserName(), loginForm.getUserPassword());
		
		// 存在するかどうかの確認
		if(userEntity.isPresent()) {
			// 存在した場合
			Integer userId = userEntity.get().getUserId();
			return userId;
		
		} else {
			// 存在しなかった場合
			Integer userId = 0;
			return userId;
			
		}
	}
	
	/**
	 * セッション情報の取得メソッド
	 * 
	 * @param session　セッション情報
	 * @return　userBean
	 */
	public UsersBean getUserSessionInformation(HttpSession session) {
		
		// セッションUserIdからユーザー情報の取得
		UsersEntity userEntity =  new UsersEntity();
		userEntity = userRepository.findByUserId((Integer) session.getAttribute("userId"));
		
		// EntityからBeanに格納
		UsersBean userBean = new UsersBean();
		BeanUtils.copyProperties(userEntity, userBean);
		
		return userBean;
		
	}

}
