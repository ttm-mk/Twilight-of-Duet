package com.twilightofduet.SaveLoad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Saveリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/2/24 tsutsumi miki
 */

@Repository
public interface SaveRepository extends JpaRepository<SaveEntity, Integer> {

}
