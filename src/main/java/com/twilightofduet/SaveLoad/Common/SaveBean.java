package com.twilightofduet.SaveLoad.Common;

import java.util.Date;

/**
 * UsersBeanクラス
 * 作成者 tsutsumi miki
 * 編集日 2025/9/2 tsutsumi miki
 */

public class SaveBean {
	//セーブID
	private Integer saveId;
	//スロットナンバー
	private Integer slotNumber;
	//メインストーリーチャプター
	private Integer mainStoryChapter;
	//作成日
	private Date createDate;
	//更新日
	private Date updateDate;
	


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
	 * スロットナンバーのゲッター
	 * @return
	 */
	public Integer getSlotNumber() {
		return slotNumber;
	}

	/**
	 * スロットナンバーのセッター
	 * @param slotNumber
	 */
	public void setSlotNumber(Integer slotNumber) {
		this.slotNumber = slotNumber;
	}

	/**
	 * メインストーリーチャプターのゲッター
	 * @return
	 */
	public Integer getMainStoryChapter() {
		return mainStoryChapter;
	}

	/**
	 * メインストーリーチャプターのセッター
	 * @param mainStoryChapter
	 */
	public void setMainStoryChapter(Integer mainStoryChapter) {
		this.mainStoryChapter = mainStoryChapter;
	}
	
	/**
	 * 作成日時のゲッター
	 * @return
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 作成日時のセッター
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * 更新日時のゲッター
	 * @return
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 更新日時のセッター
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


}
