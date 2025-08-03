package com.twilightofduet.SaveLoad.SaveLikeability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.SaveLoad.SaveFunction.SaveEntity;

/**
 * SavedLikeabilityリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/7/30 tsutsumi miki
 */

@Repository
public interface SavedLikeabilityRepository extends JpaRepository<SavedLikeabilityEntity, Integer> {
	
	SavedLikeabilityEntity findBySaveIdAndRomanceCharacterId(SaveEntity saveId, RomanceCharacterEntity romanceCharacterId);

}
