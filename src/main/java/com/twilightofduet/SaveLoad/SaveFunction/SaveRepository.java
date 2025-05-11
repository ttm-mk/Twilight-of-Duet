package com.twilightofduet.SaveLoad.SaveFunction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Saveリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/10 tsutsumi miki
 */

@Repository
public interface SaveRepository extends JpaRepository<SaveEntity, Integer> {
	
	// ユーザーIDを探す
//	List<SaveEntity> findByUserId(Integer userId);

}
