package com.twilightofduet.SaveLoad.SaveStory.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SavedCharacterStoryリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/12 tsutsumi miki
 */

@Repository
public interface SavedCharacterStoryRepository extends JpaRepository<SavedCharacterStoryEntity, Integer>{

}
