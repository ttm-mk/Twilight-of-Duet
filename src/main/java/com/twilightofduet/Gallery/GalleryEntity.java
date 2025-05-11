package com.twilightofduet.Gallery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.User.UserCommon.UsersEntity;

/**
 * Galleryエンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/10 tsutsumi miki
 */

@Entity
@Table(name = "Gallery")
public class GalleryEntity {
	
	/* ギャラリーID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gallery_gen")
	@SequenceGenerator(name = "seq_gallery_gen", sequenceName = "seq_gallery", allocationSize = 1)
	private Integer galleryId;
	
	/* ストーリーナンバー */
	// 呼んだストーリーの話数のこと
	@Column
	private Integer storyNumber;
	
	/* スチルナンバー */
	// 見たスチルの番号のこと
	@Column
	private Integer stillNumber;
	
	/* ユーザーIDの外部キー */
	@OneToOne
	@JoinColumn(name="user_id")
	private UsersEntity userId;
	
	/* キャラクターIDの外部キー */
	@OneToOne
	@JoinColumn(name="romance_character_id")
	private RomanceCharacterEntity romanceCharacterId;
	
	/**
	 * ギャラリーIDのゲッター
	 * @return
	 */
	public Integer getGalleryId() {
		return galleryId;
	}
	
	/**
	 * ギャラリーIDのセッター
	 * @param galleryId
	 */
	public void setGalleryId(Integer galleryId) {
		this.galleryId = galleryId;
	}

	/**
	 * ストーリーナンバーのゲッター
	 * @return
	 */
	public Integer getStoryNumber() {
		return storyNumber;
	}

	/**
	 * ストーリーナンバーのセッター
	 * @param storyNumber
	 */
	public void setStoryNumber(Integer storyNumber) {
		this.storyNumber = storyNumber;
	}

	/**
	 * スチルナンバーのゲッター
	 * @return
	 */
	public Integer getStillNumber() {
		return stillNumber;
	}

	/**
	 * スチルナンバーのセッター
	 * @param stillNumber
	 */
	public void setStillNumber(Integer stillNumber) {
		this.stillNumber = stillNumber;
	}

	/**
	 * ユーザーID外部キーのゲッター
	 * @return
	 */
	public UsersEntity getUserId() {
		return userId;
	}

	/**
	 * ユーザーID外部キーのセッター
	 * @param userId
	 */
	public void setUserId(UsersEntity userId) {
		this.userId = userId;
	}

	/**
	 * キャラクターID外部キーのゲッター
	 * @return
	 */
	public RomanceCharacterEntity getRomanceCharacterId() {
		return romanceCharacterId;
	}

	/**
	 * キャラクターID外部キーのセッター
	 * @param romanceCharacterId
	 */
	public void setRomanceCharacterId(RomanceCharacterEntity romanceCharacterId) {
		this.romanceCharacterId = romanceCharacterId;
	}
	
	

}
