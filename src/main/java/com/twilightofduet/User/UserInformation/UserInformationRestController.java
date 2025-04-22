package com.twilightofduet.User.UserInformation;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilightofduet.User.UserCommon.UsersRepository;

/**
 * 
 */

@RestController
@RequestMapping("/api")
public class UserInformationRestController {
	
//	private final UserInformationService userInformationService;
//
//    public UserInformationRestController(UserInformationService userInformationService) {
//        this.userInformationService = userInformationService;
//    }
	
	@Autowired
    UsersRepository userRepository;
	@Autowired
	UserInformationService userInformationService;

    /**
     * ユーザーのヒロイン名を取得するAPI
     * @param userId ユーザーID
     * @return ユーザー名
     */
    @GetMapping("/users/heroine")
    public ResponseEntity<String> getHeroineName(HttpSession session) {
        // ユーザーIDに基づいてヒロイン名を取得
        String heroineName = userInformationService.getHeroineNameById((Integer)session.getAttribute("userId"));

        // ヒロイン名が存在すれば返す
        if (heroineName != null) {
            return ResponseEntity.ok(heroineName);
        } else {
            return ResponseEntity.notFound().build();  // ヒロイン名が見つからない場合は404
        }
    }

}
