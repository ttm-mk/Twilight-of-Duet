package com.twilightofduet.SaveLoad.SaveLikeability;

import java.util.Date;

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
import com.twilightofduet.SaveLoad.SaveFunction.SaveEntity;

/**
 * SavedLikeabilityエンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/12 tsutsumi miki
 */

@Entity
@Table(name="SavedLikeability")
public class SavedLikeabilityEntity {
	
//	好感度セーブ用ID
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_saved_likeability_gen")
	@SequenceGenerator(name="seq_saved_likeability_gen", sequenceName="seq_saved_likeability", allocationSize=1)
	private Integer savedLikeabilityId;
//	好感度数
	@Column
	private Integer likeabilityNumber;
//	作成日
	@Column
	private Date createdDate;
//	更新日
	@Column
	private Date updateDate;
//	セーブIDの外部キー
	@ManyToOne
	@JoinColumn(name="save_id")
	private SaveEntity saveId;
//	キャラクターIDの外部キー
	@OneToOne
	@JoinColumn(name="romance_character_id")
	private RomanceCharacterEntity romanceCharacterId;
	
	
	/**
	 * 好感度セーブ用IDのゲッター
	 * @return
	 */
	public Integer getSavedLikeabilityId() {
		return savedLikeabilityId;
	}
	
	/**
	 * 好感度セーブ用IDのセッター
	 * @param savedLikeabilityId
	 */
	public void setSavedLikeabilityId(Integer savedLikeabilityId) {
		this.savedLikeabilityId = savedLikeabilityId;
	}
	
	/**
	 * 好感度数のゲッター
	 * @return
	 */
	public Integer getLikeabilityNumber() {
		return likeabilityNumber;
	}
	
	/**
	 * 好感度数のセッター
	 * @param likeabilityNumber
	 */
	public void setLikeabilityNumber(Integer likeabilityNumber) {
		this.likeabilityNumber = likeabilityNumber;
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
	public Date getUpdateDate() {
		return updateDate;
	}
	
	/**
	 * 更新日のセッター
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
