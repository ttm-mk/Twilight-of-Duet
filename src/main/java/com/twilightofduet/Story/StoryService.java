package com.twilightofduet.Story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * StoryService
 * 作成者 tsutsumi miki
 * 編集日 2025/3/20 tsutsumi miki
 */

@Service
public class StoryService {
	
	@Autowired
	StoryRepository storyRepository;
	
	public StoryEntity storyCreate() {
		
		StoryEntity storyEntity = new StoryEntity();
		storyEntity.setTakumiStory(0); 
		storyEntity.setSomaStory(0); 
		storyEntity.setMiyukiStory(0); 
		storyEntity.setTakutoStory(0); 
		storyEntity.setMiruStory(0); 
		storyEntity = storyRepository.save(storyEntity);
		
		return storyEntity;

		
	}

}
