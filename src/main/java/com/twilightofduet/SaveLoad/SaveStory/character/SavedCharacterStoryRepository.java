package com.twilightofduet.SaveLoad.SaveStory.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.SaveLoad.SaveFunction.SaveEntity;

/**
 * SavedCharacterStoryリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/7/31 tsutsumi miki
 */

@Repository
public interface SavedCharacterStoryRepository extends JpaRepository<SavedCharacterStoryEntity, Integer>{
	
	SavedCharacterStoryEntity findBySaveIdAndRomanceCharacterId(SaveEntity saveEntity, RomanceCharacterEntity romanceCharacterId);

}
