package com.twilightofduet.User.UserCommon;

/*
 * UserForm
 * 作成者 tsutsumi miki
 * 編集日 2025/3/1 tsutsumi miki
 */

public class UserForm {
	
//	ユーザー名
	private String userName;
//	ユーザーパスワード
	private String userPassword;
//	ヒロイン名
	private String heroineName;
//	ヒロインのあだ名
	private String heroineNickname;

	
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
