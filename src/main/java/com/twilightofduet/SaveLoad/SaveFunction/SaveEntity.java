package com.twilightofduet.SaveLoad.SaveFunction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.twilightofduet.User.UserCommon.UsersEntity;

/**
 * Saveエンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/10 tsutsumi miki
 */

@Entity
@Table(name = "Save")
public class SaveEntity {
	
	/* セーブID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_save_gen")
	@SequenceGenerator(name = "seq_save_gen", sequenceName = "seq_save", allocationSize = 1)
	private Integer saveId;
	
	/* セーブスロット数 */
	@Column
	private Integer slotNumber;
	
	/* 作成日時 */
	@Column
	private Integer createdDate;
	
	/* 更新日時 */
	@Column
	private Integer updatedDate;
	
	/* ユーザーIDの外部キー */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UsersEntity userId;
	
	
	/**
	 * セーブIDのゲッター
	 * @return
	 */
	public Integer getSaveId() {
		return saveId;
	}

	/**
	 * セーブIDのセッター
	 * @param saveId
	 */
	public void setSaveId(Integer saveId) {
		this.saveId = saveId;
	}

	/**
	 * セーブスロット数のゲッター
	 * @return
	 */
	public Integer getSlotNumber() {
		return slotNumber;
	}

	/**
	 * セーブスロット数のセッター
	 * @param slotNumber
	 */
	public void setSlotNumber(Integer slotNumber) {
		this.slotNumber = slotNumber;
	}

	/**
	 * 作成日時のゲッター
	 * @return
	 */
	public Integer getCreatedDate() {
		return createdDate;
	}

	/**
	 * 作成日時のセッター
	 * @param createdDate
	 */
	public void setCreatedDate(Integer createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 更新日時のゲッター
	 * @return
	 */
	public Integer getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 更新日時のセッター
	 * @param updatedDate
	 */
	public void setUpdatedDate(Integer updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * ユーザーIDの外部キーのゲッター
	 * @return
	 */
	public UsersEntity getUserId() {
		return userId;
	}

	/**
	 * ユーザーIDの外部キーのセッター
	 * @param userId
	 */
	public void setUserId(UsersEntity userId) {
		this.userId = userId;
	}
	

}
