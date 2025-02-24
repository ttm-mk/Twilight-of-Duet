package com.twilightofduet.Bean;

import java.io.Serializable;

/**
 * UsersBeanクラス
 * 作成者 tsutsumi miki
 * 編集日 2025/2/22 tsutsumi miki
 */

public class UsersBean implements Serializable{
//	更新用：id
	private Integer userId;
	
//	表示・更新用：ユーザー名
	private String userName;
	
//	表示・更新用：パスワード
	private String userPassword;  //TODO:おいおいハッシュ化
	
//	表示・更新用：ヒロイン名
	private String heroineName;
	
//	表示・更新用：ヒロインのあだ名
	private String heroineNickname;
	
	
	/**
	 * ユーザーIDのゲッター
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * ユーザーIDのセッター
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	/**
	 * ユーザー名のゲッター
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * ユーザー名のセッター
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * ユーザーパスワードのゲッター
	 * @return
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * ユーザーパスワードのセッター
	 * @param userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * ヒロイン名のゲッター
	 * @return
	 */
	public String getHeroineName() {
		return heroineName;
	}

	/**
	 * ヒロイン名のセッター
	 * @param heroineName
	 */
	public void setHeroineName(String heroineName) {
		this.heroineName = heroineName;
	}

	/**
	 * ヒロインのあだ名のゲッター
	 * @return
	 */
	public String getHeroineNickname() {
		return heroineNickname;
	}

	/**
	 * ヒロインのあだ名のセッター
	 * @param heroineNickname
	 */
	public void setHeroineNickname(String heroineNickname) {
		this.heroineNickname = heroineNickname;
	}
	
	

}
