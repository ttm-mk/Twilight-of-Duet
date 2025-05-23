package com.twilightofduet.Story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.User.UserCommon.UsersEntity;

/**
 * Storyリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/22 tsutsumi miki
 */

@Repository
public interface StoryRepository extends JpaRepository<StoryEntity, Integer> {
	
	StoryEntity findByUserIdAndRomanceCharacterId(UsersEntity userId, RomanceCharacterEntity romanceCharacterId);

}
