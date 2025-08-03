package com.twilightofduet.SaveLoad.SaveFunction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twilightofduet.User.UserCommon.UsersEntity;

/**
 * Saveリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/7/22 tsutsumi miki
 */

@Repository
public interface SaveRepository extends JpaRepository<SaveEntity, Integer> {
	
	// ユーザーIDを探す
//	List<SaveEntity> findByUserId(Integer userId);
	// スロットナンバーからエンティティ検索
	SaveEntity findByUserIdAndSlotNumber(UsersEntity userId, Integer slotNumber);

}
