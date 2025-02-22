package com.twilightofduet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * 好感度エンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/2/22 tsutsumi miki
 */

@Entity
@Table(name = "Likeability")
public class LikeabilityEntity {
	
	/* 好感度ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_likeability_gen")
	@SequenceGenerator(name = "seq_likeability_gen", sequenceName = "seq_likeability", allocationSize = 1)
	private Integer likeabilityId;
	
	/* 巧美の好感度 */
	@Column
	private Integer takumiLikeability;
	
	/* 颯真の好感度 */
	@Column
	private Integer somaLikeability;
	
	/* 御幸の好感度 */
	@Column
	private Integer miyukiLikeability;
	
	/* 巧斗の好感度 */
	@Column
	private Integer takutoLikeability;
	
	/* 実瑠の好感度 */
	@Column
	private Integer miruLikeability;
	
	/* 攻略対象 */
	@Column
	private Integer targetNumber;

	
	/**
	 * 好感度IDのゲッター
	 * @return
	 */
	public Integer getLikeabilityId() {
		return likeabilityId;
	}

	/**
	 * 好感度IDのセッター
	 * @param likeabilityId
	 */
	public void setLikeabilityId(Integer likeabilityId) {
		this.likeabilityId = likeabilityId;
	}

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
	
	

}
