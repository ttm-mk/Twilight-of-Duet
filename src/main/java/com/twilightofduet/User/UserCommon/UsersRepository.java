package com.twilightofduet.User.UserCommon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Usersリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/2/24 tsutsumi miki
 */

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

}
