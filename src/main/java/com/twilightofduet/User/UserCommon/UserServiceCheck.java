package com.twilightofduet.User.UserCommon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * User関連のサービスチェック用クラス
 * 作成者 tsutsumi miki
 * 編集日 2025/3/21 tsutsumi miki
 */


@Service
public class UserServiceCheck {
	
	@Autowired
	UsersRepository userRepository;
	
	/**
	 * ユーザー名とパスワードの組み合わせチェックメソッドの本体
	 * 
	 * @param user　ユーザー情報
	 * @return　True:組み合わせがあった場合　False：組み合わせがなかった場合
	 */
	public Boolean userInformationCheck(UserForm user) {
		// リポジトリ使用して同じ組み合わせを探す
		Optional<UsersEntity> checkAnswer = userRepository.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
		// 同じ組み合わせがあったかどうかの結果を返す
		return checkAnswer.isPresent();
		
	}

}
