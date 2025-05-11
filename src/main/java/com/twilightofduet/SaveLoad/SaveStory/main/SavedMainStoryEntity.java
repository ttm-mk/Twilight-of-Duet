package com.twilightofduet.SaveLoad.SaveStory.main;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.twilightofduet.SaveLoad.SaveFunction.SaveEntity;

/**
 * SavedMainStoryエンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/12 tsutsumi miki
 */

@Entity
@Table(name="SavedMainStory")
public class SavedMainStoryEntity {
	
	// メインストーリーセーブ用テーブルのID
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_saved_main_story_gen")
	@SequenceGenerator(name="seq_saved_main_story_gen", sequenceName="seq_saved_main_story", allocationSize=1)
	private Integer savedMainStoryId;
	
	// チャプター番号
	@Column
	private Integer chapterNumber;
	
	// 作成日
	@Column
	private Date createdDate;
	
	// 更新日
	@Column
	private Date updatedDate;
	
	// セーブIDの外部キー
	@ManyToOne
	@JoinColumn(name="save_id")
	private SaveEntity saveId;

	
	/**
	 * メインストーリーセーブ用IDのゲッター
	 * @return
	 */
	public Integer getSavedMainStoryId() {
		return savedMainStoryId;
	}

	/**
	 * メインストーリーセーブ用IDのセッター
	 * @param savedMainStoryId
	 */
	public void setSavedMainStoryId(Integer savedMainStoryId) {
		this.savedMainStoryId = savedMainStoryId;
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
	 * 作成日のゲッター
	 * @return
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * 作成日のセッター
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 更新日のゲッター
	 * @return
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 更新日のセッター
	 * @param updatedDate
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * セーブID外部キーのゲッター
	 * @return
	 */
	public SaveEntity getSaveId() {
		return saveId;
	}

	/**
	 * セーブID外部キーのセッター
	 * @param saveId
	 */
	public void setSaveId(SaveEntity saveId) {
		this.saveId = saveId;
	}
	
}
