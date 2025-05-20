package com.twilightofduet.Story;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.Character.RomanceCharacterRepository;
import com.twilightofduet.User.UserCommon.UsersRepository;

/**
 * StoryRestController
 * 作成者 tsutsumi miki
 * 編集日 2025/5/21 tsutsumi miki
 */

@RestController
@RequestMapping("/api/story")
public class StoryRestController {
	
	@Autowired
	UsersRepository userRepository;
	@Autowired
	StoryService storyService;
	@Autowired
	RomanceCharacterRepository characterRepository;
	@Autowired
	StoryRepository storyRepository;
    
    /**
     * メインストーリー数値を取得するAPI
     * @param session
     * @return　メインストーリー数値
     */
    @GetMapping("/story-main")
    public ResponseEntity<Integer> getMainStoryInt(HttpSession session) {
        // ユーザーIDからUserEntityを取得、MainStoryIntの取得
        RomanceCharacterEntity characterEntity = characterRepository.findByRomanceCharacterId("メイン");
        Integer characterId = characterEntity.getRomanceCharacterId();
        StoryEntity storyEntity = storyRepository.findByStoryId((Integer)session.getAttribute("userId"), characterId);
        Integer mainStory = (Integer)storyEntity.getChapterNumber();
        
        // メインストーリー数値が存在すれば返す
        if (mainStory != null) {
            return ResponseEntity.ok(mainStory);
        } else {
            return ResponseEntity.notFound().build();  // メインストーリー数値が見つからない場合は404
        }
    }
    
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
        // ユーザーIDからUserEntityを取得、MainStoryIntの取得
        RomanceCharacterEntity characterEntity = characterRepository.findByRomanceCharacterId("メイン");
        Integer characterId = characterEntity.getRomanceCharacterId();
        StoryEntity storyEntity = storyRepository.findByStoryId((Integer)session.getAttribute("userId"), characterId);
        Integer mainStory = (Integer)storyEntity.getChapterNumber();
    	
    	if(storyDTO.getMainStory() > mainStory) {
    		return true;
    		
    	} else {
    		return false;
    		
    	}
    	
    }

}
