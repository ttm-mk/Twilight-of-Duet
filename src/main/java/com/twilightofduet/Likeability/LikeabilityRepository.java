package com.twilightofduet.Likeability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Likeabilityリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/2/24 tsutsumi miki
 */

@Repository
public interface LikeabilityRepository extends JpaRepository<LikeabilityEntity, Integer>{

}
