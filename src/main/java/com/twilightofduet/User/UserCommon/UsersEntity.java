package com.twilightofduet.User.UserCommon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


/**
 * Usersエンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/11 tsutsumi miki
 */

@Entity
@Table(name = "Users")
public class UsersEntity {
	
	/* ユーザーID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users_gen")
	@SequenceGenerator(name = "seq_users_gen", sequenceName = "seq_users", allocationSize = 1)
	private Integer userId;
	
	/* ユーザー名 */
	@Column
	private String userName;
	
	/* ユーザーパスワード */
	@Column
	private String userPassword;
	
	/* ヒロインの名前 */
	@Column
	private String heroineName;
	
	/* ヒロインのあだな */
	@Column
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
