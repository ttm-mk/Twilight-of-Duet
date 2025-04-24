package com.twilightofduet.User.UserInformation;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilightofduet.User.UserCommon.UsersRepository;

/**
 * UsersInformationRestController
 * 作成者 tsutsumi miki
 * 編集日 2025/4/23 tsutsumi miki
 */

@RestController
@RequestMapping("/api/users")
public class UserInformationRestController {
	
	@Autowired
    UsersRepository userRepository;
	@Autowired
	UserInformationService userInformationService;

    /**
     * ユーザーのヒロイン名を取得するAPI
     * @param userId ユーザーID
     * @return ユーザー名
     */
    @GetMapping("/heroine")
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
    
    /**
     * ユーザーのヒロインのあだ名を取得するAPI
     * @param userId ユーザーID
     * @return ユーザー名
     */
    @GetMapping("/heroine-nickname")
    public ResponseEntity<String> getHeroineNickname(HttpSession session) {
        // ユーザーIDに基づいてヒロイン名を取得
        String heroineNickname = userInformationService.getHeroineNicknameById((Integer)session.getAttribute("userId"));

        // ヒロイン名が存在すれば返す
        if (heroineNickname != null) {
            return ResponseEntity.ok(heroineNickname);
        } else {
            return ResponseEntity.notFound().build();  // あだ名が見つからない場合は404
        }
    }
    

}
