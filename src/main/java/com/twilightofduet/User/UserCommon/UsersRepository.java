package com.twilightofduet.User.UserCommon;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Usersリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/2/24 tsutsumi miki
 */

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
	
	// ユーザー名とパスワードの同じ組み合わせが存在しないかチェック用
	Optional<UsersEntity> findByUserNameAndUserPassword(String userName, String userPassword);
//	// ログイン用
//	List<UsersEntity> findByUserId(String userName, String userPassword);

}
