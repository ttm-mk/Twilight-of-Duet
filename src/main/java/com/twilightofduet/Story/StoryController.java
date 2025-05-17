package com.twilightofduet.Story;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.twilightofduet.User.UserAuth.UserAuthService;
import com.twilightofduet.User.UserCommon.UsersBean;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/**
 *  StoryController
 * 作成者 tsutsumi miki
 * 編集日 2025/4/20 tsutsumi miki
 */

@Controller
public class StoryController {
	
	@Autowired
	UserAuthService userAuthService;
	@Autowired
	UsersRepository userRepository;
	@Autowired
	StoryRepository storyRepository;
	
	/**
	 * ストーリートップ画面
	 * @return
	 */
	@GetMapping("/story")
	public String StoryTopDisplay(HttpSession session, Model model) {
		// Bean作成しセッション情報を取得して格納する
		UsersBean userBean = userAuthService.getUserSessionInformation(session);	    
	    model.addAttribute("userId", userBean.getUserId());
	    
	    // UserIDとCharacterIdからストーリーIDの取得と格納
	    // TODO:ここ、各キャラクターのIDとチャプター番号取得してJSに渡さないといけないから色々変えないと。
	    // StoryServiceに各キャラクター格納したEntityを返すメソッド作らないといけない。
	    StoryEntity storyEntity = storyRepository.findByStoryId(userBean.getUserId(), 0); //仮で0入れているけど実際はキャラクターID
	    // キャラクターのチャプター番号取得してモデルに格納
	    model.addAttribute("chapterNumber", storyEntity.getChapterNumber());
	    
		return "story/story.html";
	}
	
	/**
	 * メインストーリー1話
	 * @return
	 */
	@GetMapping("/story/main/1")
	public String StoryMain1(HttpSession session, Model model) {
		// Bean作成しセッション情報を取得して格納する
		UsersBean userBean = userAuthService.getUserSessionInformation(session);
		// ユーザーIDをモデルに追加
	    model.addAttribute("userId", userBean.getUserId());
	    // サイドバーにStory数値を返す記述
	    UsersEntity userEntity = userRepository.findByUserId(userBean.getUserId());
	    StoryEntity storyEntity = userEntity.getStoryId();
	    model.addAttribute("mainStory", storyEntity.getMainStory());

		
		return "story/character/main/story_main1.html";
	}
	
	/**
	 * メインストーリー2話
	 * @return
	 */
	@GetMapping("/story/main/2")
	public String StoryMain2(HttpSession session, Model model) {
		// Bean作成しセッション情報を取得して格納する
		UsersBean userBean = userAuthService.getUserSessionInformation(session);
		// ユーザーIDをモデルに追加
	    model.addAttribute("userId", userBean.getUserId());
	    
	    // サイドバーにStory数値を返す記述
	    UsersEntity userEntity = userRepository.findByUserId(userBean.getUserId());
	    StoryEntity storyEntity = userEntity.getStoryId();
	    model.addAttribute("mainStory", storyEntity.getMainStory());
		
		return "story/character/main/story_main2.html";
	}
	
	/**
	 * キャラクターストーリー巧美1話
	 * @return
	 */
	@GetMapping("/story/SonoyamaTakumi/1")
	public String StoryTakumi1( ) {
		return "story/character/sonoyama_takumi/story_takumi1.html";
	}

}
