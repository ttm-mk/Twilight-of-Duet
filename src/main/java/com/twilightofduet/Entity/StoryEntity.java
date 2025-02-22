package com.twilightofduet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Storyエンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/2/22 tsutsumi miki
 */

@Entity
@Table(name = "Story")
public class StoryEntity {
	
	/* ストーリーID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_story_gen")
	@SequenceGenerator(name = "seq_story_gen", sequenceName = "seq_story", allocationSize = 1)
	private Integer storyId;
	
	/* メインストーリー */
	@Column
	private Integer mainStory;

	/* 巧美ストーリー */
	@Column
	private Integer takumiStory;
	
	/* 颯真ストーリー */
	@Column
	private Integer somaStory;
	
	/* 御幸ストーリー */
	@Column
	private Integer miyukiStory;
	
	/* 巧斗ストーリー */
	@Column
	private Integer takutoStory;
	
	/* 実瑠ストーリー */
	@Column
	private Integer miruStory;

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
	 * メインストーリーのゲッター
	 * @return
	 */
	public Integer getMainStory() {
		return mainStory;
	}

	/**
	 * メインストーリーのセッター
	 * @param mainStory
	 */
	public void setMainStory(Integer mainStory) {
		this.mainStory = mainStory;
	}

	/**
	 * 巧美ストーリーのゲッター
	 * @return
	 */
	public Integer getTakumiStory() {
		return takumiStory;
	}

	/**
	 * 巧美ストーリーのセッター
	 * @param takumiStory
	 */
	public void setTakumiStory(Integer takumiStory) {
		this.takumiStory = takumiStory;
	}

	/**
	 * 颯真ストーリーのゲッター
	 * @return
	 */
	public Integer getSomaStory() {
		return somaStory;
	}

	/**
	 * 颯真ストーリーのセッター
	 * @param somaStory
	 */
	public void setSomaStory(Integer somaStory) {
		this.somaStory = somaStory;
	}

	/**
	 * 御幸ストーリーのゲッター
	 * @return
	 */
	public Integer getMiyukiStory() {
		return miyukiStory;
	}

	/**
	 * 御幸ストーリーのセッター
	 * @param miyukiStory
	 */
	public void setMiyukiStory(Integer miyukiStory) {
		this.miyukiStory = miyukiStory;
	}

	/**
	 * 巧斗ストーリーのゲッター
	 * @return
	 */
	public Integer getTakutoStory() {
		return takutoStory;
	}

	/**
	 * 巧斗ストーリーのセッター
	 * @param takutoStory
	 */
	public void setTakutoStory(Integer takutoStory) {
		this.takutoStory = takutoStory;
	}

	/**
	 * 実瑠ストーリーのゲッター
	 * @return
	 */
	public Integer getMiruStory() {
		return miruStory;
	}

	/**
	 * 実瑠ストーリーのセッター
	 * @param miruStory
	 */
	public void setMiruStory(Integer miruStory) {
		this.miruStory = miruStory;
	}
	
}
