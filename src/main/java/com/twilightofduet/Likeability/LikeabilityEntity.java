package com.twilightofduet.Likeability;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.User.UserCommon.UsersEntity;

/**
 * 好感度エンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/23 tsutsumi miki
 */

@Entity
@Table(name = "Likeability")
public class LikeabilityEntity {
	
	/* 好感度ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_likeability_gen")
	@SequenceGenerator(name = "seq_likeability_gen", sequenceName = "seq_likeability", allocationSize = 1)
	private Integer likeabilityId;
	
	/* 好感度 */
	@Column
	private Integer characterLikeability;
	
	/* 攻略対象 */
	@Column
	private Integer targetNumber;
	
	/* ユーザーIDの外部キー */
	@OneToOne
	@JoinColumn(name="user_id")
	private UsersEntity userId;

	/* キャラクターIDの外部キー */
	@ManyToOne
	@JoinColumn(name="romance_character_id")
	private RomanceCharacterEntity romanceCharacterId;
	
	/**
	 * 引数ありのコンストラクタ
	 * 
	 * @param characterLikeability
	 * @param targetNumber
	 * @param userId
	 * @param romanceCharacterId
	 */
	public LikeabilityEntity(Integer characterLikeability,
			Integer targetNumber,UsersEntity userId, RomanceCharacterEntity romanceCharacterId) {
		
		this.characterLikeability = characterLikeability;
		this.targetNumber = targetNumber;
		this.userId = userId;
		this.romanceCharacterId = romanceCharacterId;
		
	}

	
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
	 * 好感度のゲッター
	 * @return
	 */
	public Integer getCharacterLikeability() {
		return characterLikeability;
	}

	/**
	 * 好感度のセッター
	 * @param characterLikeability
	 */
	public void setCharacterLikeability(Integer characterLikeability) {
		this.characterLikeability = characterLikeability;
	}

	/**
	 * 最終攻略対象のゲッター
	 * @return
	 */
	public Integer getTargetNumber() {
		return targetNumber;
	}

	/**
	 * 最終攻略対象のセッター
	 * @param targetNumber
	 */
	public void setTargetNumber(Integer targetNumber) {
		this.targetNumber = targetNumber;
	}

	/**
	 * ユーザーID外部キーのセッター
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
	 * キャラクターIDの外部キーのゲッター
	 * @return
	 */
	public RomanceCharacterEntity getRomanceCharacterId() {
		return romanceCharacterId;
	}

	/**
	 * キャラクターIDの外部キーのセッター
	 * @param romanceCharacterId
	 */
	public void setRomanceCharacterId(RomanceCharacterEntity romanceCharacterId) {
		this.romanceCharacterId = romanceCharacterId;
	}

	
}
