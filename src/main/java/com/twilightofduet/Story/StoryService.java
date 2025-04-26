package com.twilightofduet.Story;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * StoryService
 * 作成者 tsutsumi miki
 * 編集日 2025/3/20 tsutsumi miki
 */

@Service
public class StoryService {
	
	@Autowired
	StoryRepository storyRepository;
	@Autowired
	UsersRepository userRepository;
	
	public StoryEntity storyCreate() {
		
		StoryEntity storyEntity = new StoryEntity();
		storyEntity.setMainStory(0);
		storyEntity.setTakumiStory(0); 
		storyEntity.setSomaStory(0); 
		storyEntity.setMiyukiStory(0); 
		storyEntity.setTakutoStory(0); 
		storyEntity.setMiruStory(0); 
		storyEntity = storyRepository.save(storyEntity);
		
		return storyEntity;

		
	}
	
    @PostMapping("/story/main/save/complete")
    public Integer saveStoryMain(StoryDTO storyDTO, HttpSession session){
    	
      UsersEntity userEntity = userRepository.findByUserId((Integer)session.getAttribute("userId"));
      StoryEntity storyEntity = userEntity.getStoryId();
      storyEntity.setMainStory(storyDTO.getMainStory());
      storyRepository.save(storyEntity);
      
      if(storyEntity.getMainStory() == storyDTO.getMainStory()){
    	  return storyEntity.getMainStory();
    	  
      } else {
    	  return null;
      }
      
      
    }

}
