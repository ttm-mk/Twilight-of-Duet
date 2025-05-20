package com.twilightofduet.Story;

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
 * Storyエンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/17 tsutsumi miki
 */

@Entity
@Table(name = "Story")
public class StoryEntity {
	
	/* ストーリーID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_story_gen")
	@SequenceGenerator(name = "seq_story_gen", sequenceName = "seq_story", allocationSize = 1)
	private Integer storyId;
	
	/* チャプター番号 */
	@Column
	private Integer chapterNumber;

	/* ユーザーIDの外部キー */
	@OneToOne
	@JoinColumn(name="user_id")
	private UsersEntity userId;
	
	/* キャラクターIDの外部キー */
	@OneToOne
	@JoinColumn(name="romance_character_id")
	private RomanceCharacterEntity romanceCharacterId;
	
	/**
	 * 引数ありのコンストラクタ
	 * 
	 * @param romanceCharacterId
	 * @param userId
	 * @param chapterNumber
	 */
	public StoryEntity(RomanceCharacterEntity romanceCharacterId, UsersEntity userId, Integer chapterNumber) {
		this.romanceCharacterId = romanceCharacterId;
		this.userId = userId;
		this.chapterNumber = chapterNumber;
	}

	/**
	 * ストーリーIDのゲッター
	 * @return
	 */
	public Integer getStoryId() {
		return storyId;
	}

	/**
	 * ストーリーIDのセッター
	 * @param storyId
	 */
	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}

	/**
	 * チャプター番号のゲッター
	 * @return
	 */
	public Integer getChapterNumber() {
		return chapterNumber;
	}

	/**
	 * チャプター番号のセッター
	 * @param chapterNumber
	 */
	public void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
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
