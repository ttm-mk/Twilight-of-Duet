package com.twilightofduet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Galleryエンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/2/22 tsutsumi miki
 */

@Entity
@Table(name = "Gallery")
public class GalleryEntity {
	
	/* ギャラリーID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gallery_gen")
	@SequenceGenerator(name = "seq_gallery_gen", sequenceName = "seq_gallery", allocationSize = 1)
	private Integer galleryId;
	
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
	
	/* メインスチル */
	@Column
	private Integer mainStill;
	
	/* 巧美スチル */
	@Column
	private Integer takumiStill;
	
	/* 颯真スチル */
	@Column
	private Integer somaStill;
	
	/* 御幸スチル */
	@Column
	private Integer miyukiStill;
	
	/* 巧斗スチル */
	@Column
	private Integer takutoStill;
	
	/* 実瑠スチル */
	@Column
	private Integer miruStill;
	
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
	 * メインストーリーカラムのゲッター
	 * @return
	 */
	public Integer getMainStory() {
		return mainStory;
	}

	/**
	 * メインストーリーカラムのセッター
	 * @param mainStory
	 */
	public void setMainStory(Integer mainStory) {
		this.mainStory = mainStory;
	}

	/**
	 * 巧美ストーリーカラムのゲッター
	 * @return
	 */
	public Integer getTakumiStory() {
		return takumiStory;
	}

	/**
	 * 巧美ストーリーカラムのセッター
	 * @param takumiStory
	 */
	public void setTakumiStory(Integer takumiStory) {
		this.takumiStory = takumiStory;
	}

	/**
	 * 颯真ストーリーカラムのゲッター
	 * @return
	 */
	public Integer getSomaStory() {
		return somaStory;
	}

	/**
	 * 颯真ストーリーカラムのセッター
	 * @param somaStory
	 */
	public void setSomaStory(Integer somaStory) {
		this.somaStory = somaStory;
	}

	/**
	 * 御幸ストーリーカラムのゲッター
	 * @return
	 */
	public Integer getMiyukiStory() {
		return miyukiStory;
	}

	/**
	 * 御幸ストーリーカラムのセッター
	 * @param miyukiStory
	 */
	public void setMiyukiStory(Integer miyukiStory) {
		this.miyukiStory = miyukiStory;
	}

	/**
	 * 巧斗ストーリーカラムのゲッター
	 * @return
	 */
	public Integer getTakutoStory() {
		return takutoStory;
	}

	/**
	 * 巧斗ストーリーカラムのセッター
	 * @param takutoStory
	 */
	public void setTakutoStory(Integer takutoStory) {
		this.takutoStory = takutoStory;
	}

	/**
	 * 実瑠ストーリーカラムのゲッター
	 * @return
	 */
	public Integer getMiruStory() {
		return miruStory;
	}

	/**
	 * 実瑠ストーリーカラムのセッター
	 * @param miruStory
	 */
	public void setMiruStory(Integer miruStory) {
		this.miruStory = miruStory;
	}

	/**
	 * メインスチルカラムのゲッター
	 * @return
	 */
	public Integer getMainStill() {
		return mainStill;
	}

	/**
	 * メインスチルカラムのセッター
	 * @param mainStill
	 */
	public void setMainStill(Integer mainStill) {
		this.mainStill = mainStill;
	}

	/**
	 * 巧美スチルカラムのゲッター
	 * @return
	 */
	public Integer getTakumiStill() {
		return takumiStill;
	}

	/**
	 * 巧美スチルカラムのセッター
	 * @param takumiStill
	 */
	public void setTakumiStill(Integer takumiStill) {
		this.takumiStill = takumiStill;
	}

	/**
	 * 颯真スチルカラムのゲッター
	 * @return
	 */
	public Integer getSomaStill() {
		return somaStill;
	}

	/**
	 * 颯真スチルカラムのセッター
	 * @param somaStill
	 */
	public void setSomaStill(Integer somaStill) {
		this.somaStill = somaStill;
	}

	/**
	 * 御幸スチルカラムのゲッター
	 * @return
	 */
	public Integer getMiyukiStill() {
		return miyukiStill;
	}

	/**
	 * 御幸スチルカラムのセッター
	 * @param miyukiStill
	 */
	public void setMiyukiStill(Integer miyukiStill) {
		this.miyukiStill = miyukiStill;
	}

	/**
	 * 巧斗スチルカラムのゲッター
	 * @return
	 */
	public Integer getTakutoStill() {
		return takutoStill;
	}

	/**
	 * 巧斗スチルカラムのセッター
	 * @param takutoStill
	 */
	public void setTakutoStill(Integer takutoStill) {
		this.takutoStill = takutoStill;
	}

	/**
	 * 実瑠スチルカラムのゲッター
	 * @return
	 */
	public Integer getMiruStill() {
		return miruStill;
	}

	/**
	 * 実瑠スチルカラムのセッター
	 * @param miruStill
	 */
	public void setMiruStill(Integer miruStill) {
		this.miruStill = miruStill;
	}
	
	

}
