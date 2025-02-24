package com.twilightofduet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twilightofduet.Entity.StoryEntity;

/**
 * Storyリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/2/24 tsutsumi miki
 */

@Repository
public interface StoryRepository extends JpaRepository<StoryEntity, Integer> {

}
