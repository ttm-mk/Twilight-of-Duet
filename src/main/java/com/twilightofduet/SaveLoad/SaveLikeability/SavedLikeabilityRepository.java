package com.twilightofduet.SaveLoad.SaveLikeability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SavedLikeabilityリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/12 tsutsumi miki
 */

@Repository
public interface SavedLikeabilityRepository extends JpaRepository<SavedLikeabilityEntity, Integer> {

}
