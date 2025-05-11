package com.twilightofduet.SaveLoad.SaveStory.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Storyリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/12 tsutsumi miki
 */

@Repository
public interface SavedMainStoryRepository extends JpaRepository<SavedMainStoryEntity, Integer>{

}
