package com.twilightofduet.SaveLoad.SaveStory.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twilightofduet.SaveLoad.SaveFunction.SaveEntity;

/**
 * Storyリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/7/25 tsutsumi miki
 */

@Repository
public interface SavedMainStoryRepository extends JpaRepository<SavedMainStoryEntity, Integer>{
	
	SavedMainStoryEntity findBySaveId(SaveEntity saveId);

}
