package com.twilightofduet.Common;

/*
 * LoginForm
 * 作成者 tsutsumi miki
 * 編集日 2025/3/22 tsutsumi miki
 */

public class LoginForm {
	// ユーザー名
	private String userName;
	// ユーザーパスワード
	private String userPassword;
	
	/**
	 * ユーザー名のゲッター
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * ユーザー名のセッター
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * ユーザーパスワードのゲッター
	 * 
	 * @return
	 */
	public String getUserPassword() {
		return userPassword;
	}
	
	/**
	 * ユーザーパスワードのセッター
	 * 
	 * @param userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

}
