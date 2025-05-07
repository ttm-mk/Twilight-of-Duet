package com.twilightofduet.Likeability;

/**
 * 好感度DTO
 * 作成者 tsutsumi miki
 * 編集日 2025/5/7 tsutsumi miki
 */


public class LikeabilityRequestDTO {
	
	/* 巧美の好感度 */
	private Integer takumiLikeability;
	
	/* 颯真の好感度 */
	private Integer somaLikeability;
	
	/* 御幸の好感度 */
	private Integer miyukiLikeability;
	
	/* 巧斗の好感度 */
	private Integer takutoLikeability;
	
	/* 実瑠の好感度 */
	private Integer miruLikeability;
	
	/* 攻略対象 */
	private Integer targetNumber;
	
	/* ストーリーナンバー */
	private Integer storyNumber;
	
	/* ストーリーのタイプ（メインとかキャラクターとか） */
	private String storyType;


	/**
	 *巧美の好感度のゲッター
	 * @return
	 */
	public Integer getTakumiLikeability() {
		return takumiLikeability;
	}

	/**
	 * 巧美の好感度のセッター
	 * @param takumiLikeability
	 */
	public void setTakumiLikeability(Integer takumiLikeability) {
		this.takumiLikeability = takumiLikeability;
	}

	/*
	 *颯真の好感度のゲッター 
	 * @return
	 */
	public Integer getSomaLikeability() {
		return somaLikeability;
	}

	/**
	 * 颯真の好感度のセッター
	 * @param somaLikeability
	 */
	public void setSomaLikeability(Integer somaLikeability) {
		this.somaLikeability = somaLikeability;
	}

	/**
	 * 御幸の好感度のゲッター
	 * @return
	 */
	public Integer getMiyukiLikeability() {
		return miyukiLikeability;
	}

	/**
	 * 御幸の好感度のセッター
	 * @param miyukiLikeability
	 */
	public void setMiyukiLikeability(Integer miyukiLikeability) {
		this.miyukiLikeability = miyukiLikeability;
	}

	/**
	 * 巧斗の好感度のゲッター
	 * @return
	 */
	public Integer getTakutoLikeability() {
		return takutoLikeability;
	}

	/**
	 * 巧斗の好感度のセッター
	 * @param takutoLikeability
	 */
	public void setTakutoLikeability(Integer takutoLikeability) {
		this.takutoLikeability = takutoLikeability;
	}

	/**
	 * 実瑠の好感度のゲッター
	 * @return
	 */
	public Integer getMiruLikeability() {
		return miruLikeability;
	}

	/**
	 * 実瑠の好感度のセッター
	 * @param miruLikeability
	 */
	public void setMiruLikeability(Integer miruLikeability) {
		this.miruLikeability = miruLikeability;
	}

	/**
	 * 攻略対象のゲッター
	 * @return
	 */
	public Integer getTargetNumber() {
		return targetNumber;
	}

	/**
	 * 攻略対象のセッター
	 * @param targetNumber
	 */
	public void setTargetNumber(Integer targetNumber) {
		this.targetNumber = targetNumber;
	}

	/**
	 * ストーリーナンバーのゲッター
	 * 
	 * @return
	 */
	public Integer getStoryNumber() {
		return storyNumber;
	}

	/**
	 * ストーリーナンバーのセッター
	 * 
	 * @param storyNumber
	 */
	public void setStoryNumber(Integer storyNumber) {
		this.storyNumber = storyNumber;
	}

	/**
	 * ストーリータイプのゲッター
	 * 
	 * @return
	 */
	public String getStoryType() {
		return storyType;
	}

	/**
	 * ストーリータイプのセッター
	 * 
	 * @param storyType
	 */
	public void setStoryType(String storyType) {
		this.storyType = storyType;
	}
	

}
