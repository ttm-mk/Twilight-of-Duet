package com.twilightofduet.User.UserCommon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.twilightofduet.Gallery.GalleryEntity;
import com.twilightofduet.Likeability.LikeabilityEntity;
import com.twilightofduet.Story.StoryEntity;


/**
 * Usersエンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/2/22 tsutsumi miki
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
	
	/* ストーリーID外部キー */
	@OneToOne
	@JoinColumn(name = "story_id")
	private StoryEntity storyId;
	
	/* ギャラリーID外部キー */
	@OneToOne
	@JoinColumn(name = "gallery_id")
	private GalleryEntity galleryId;
	
	/* 好感度ID外部キー */
	@OneToOne
	@JoinColumn(name = "likeability_id")
	private LikeabilityEntity likeabilityId;
	

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

	/**
	 * ストーリーIDの外部キーのゲッター
	 * @return
	 */
	public StoryEntity getStoryId() {
		return storyId;
	}

	/**
	 * ストーリーIDの外部キーのセッター
	 * @param storyId
	 */
	public void setStoryId(StoryEntity storyId) {
		this.storyId = storyId;
	}

	/**
	 * ギャラリーIDの外部キーのゲッター
	 * @return
	 */
	public GalleryEntity getGalleryId() {
		return galleryId;
	}

	/**
	 * ギャラリーIDの外部キーのセッター
	 * @param galleryId
	 */
	public void setGalleryId(GalleryEntity galleryId) {
		this.galleryId = galleryId;
	}

	/**
	 * 好感度IDの外部キーのゲッター
	 * @return
	 */
	public LikeabilityEntity getLikeabilityId() {
		return likeabilityId;
	}

	/**
	 * 好感度IDの外部キーのセッター
	 * @param likeabilityId
	 */
	public void setLikeabilityId(LikeabilityEntity likeabilityId) {
		this.likeabilityId = likeabilityId;
	}
	
	
}
