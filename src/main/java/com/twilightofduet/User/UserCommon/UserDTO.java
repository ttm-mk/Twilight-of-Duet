package com.twilightofduet.User.UserCommon;


/*
 * UserDTO
 * 作成者 tsutsumi miki
 * 編集日 2025/3/21 tsutsumi miki
 */

public class UserDTO {
	// ユーザーID
	private Integer userID;
	//ユーザー名
	private String userName;
	//ユーザーパスワード
	private String userPassword;

	/**
	 * ユーザーIDのゲッター
	 * 
	 * @return
	 */
	public Integer getUserID() {
		return userID;
	}

	/**
	 * ユーザーIDのセッター
	 * 
	 * @param userID
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

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
