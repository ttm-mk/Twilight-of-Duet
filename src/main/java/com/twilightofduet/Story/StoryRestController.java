package com.twilightofduet.Story;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/**
 * StoryRestController
 * 作成者 tsutsumi miki
 * 編集日 2025/4/27 tsutsumi miki
 */

@RestController
@RequestMapping("/api/story")
public class StoryRestController {
	
	@Autowired
	UsersRepository userRepository;
	@Autowired
	StoryService storyService;
	
//    /**
//     * StoryID取得するAPI
//     * @param session
//     * @return storyId
//     */
//    @GetMapping("/story-id")
//    public ResponseEntity<Integer> getStoryIid(HttpSession session) {
//        // ユーザーIDからUserEntityを取得、StoryIDの取得
//        UsersEntity userEntity = userRepository.findByUserId((Integer)session.getAttribute("userId"));
//        StoryEntity storyEntity = userEntity.getStoryId();
//        Integer storyId = (Integer)storyEntity.getStoryId();
//
//        // ストーリーIDが存在すれば返す
//        if (storyId != null) {
//            return ResponseEntity.ok(storyId);
//        } else {
//            return ResponseEntity.notFound().build();  // ストーリーIDが見つからない場合は404
//        }
//    }
    
//    /**
//     * メインストーリー数値を取得するAPI
//     * @param session
//     * @return　メインストーリー数値
//     */
//    @GetMapping("/story-main")
//    public ResponseEntity<Integer> getMainStoryInt(HttpSession session) {
//        // ユーザーIDからUserEntityを取得、MainStoryIntの取得
//        UsersEntity userEntity = userRepository.findByUserId((Integer)session.getAttribute("userId"));
//        StoryEntity storyEntity = userEntity.getStoryId();
//        Integer mainStory = (Integer)storyEntity.getMainStory();
//        
//        // メインストーリー数値が存在すれば返す
//        if (mainStory != null) {
//            return ResponseEntity.ok(mainStory);
//        } else {
//            return ResponseEntity.notFound().build();  // メインストーリー数値が見つからない場合は404
//        }
//    }
	/**
	 * StoryDTOの数値が期待値以上⇒保存⇒ResponseEntityに返す
	 * 
	 * @param storyDTO　JSから送られたMainStory数値
	 * @param session　セッション
	 * @return　ResponseEntity
	 */
    @PostMapping("/main/complete")
    public ResponseEntity<Integer> saveStoryMainInt(@RequestBody StoryDTO storyDTO, HttpSession session){
    	if(storyNumberConditionCheck(storyDTO, session)) {
    		Integer responseInt = storyService.saveStoryMain(storyDTO, session);
    		return ResponseEntity.ok(responseInt);
    
    	} else {
    		return ResponseEntity.notFound().build();
    		
    	}
    	
    }
    
    /**
     * StoryDTOの数値がユーザーの保持するStory数値以上か確認
     * 
     * @param storyDTO　JSから送られたMainStoryの数値
     * @param session　セッション
     * @return　Boolean
     */
    public boolean storyNumberConditionCheck(StoryDTO storyDTO, HttpSession session) {
    	UsersEntity userEntity = userRepository.findByUserId((Integer)session.getAttribute("userId"));
    	StoryEntity storyEntity = userEntity.getStoryId();
    	
    	if(storyDTO.getMainStory() >= storyEntity.getMainStory()) {
    		return true;
    		
    	} else {
    		return false;
    		
    	}
    	
    }

}
