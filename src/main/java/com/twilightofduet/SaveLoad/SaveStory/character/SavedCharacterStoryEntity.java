package com.twilightofduet.SaveLoad.SaveStory.character;

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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.SaveLoad.SaveFunction.SaveEntity;

/**
 * SavedCharacterStoryエンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/7/30 tsutsumi miki
 */

@Entity
@Table(name="SavedCharacterStory")
public class SavedCharacterStoryEntity {
	
//	キャラクターストーリーセーブ用ID
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_saved_character_story_gen")
	@SequenceGenerator(name="seq_saved_character_story_gen", sequenceName="seq_saved_character_story", allocationSize=1)
	private Integer savedCharacterStoryId;
//	チャプター番号
	@Column
	private Integer chapterNumber;
//	作成日
	@CreatedDate
	@Column
	private Date createdDate;
//	更新日
	@LastModifiedDate
	@Column
	private Date updatedDate;
//	セーブIDの外部キー
	@ManyToOne
	@JoinColumn(name="save_id")
	private SaveEntity saveId;
//	キャラクターIDの外部キー
	@ManyToOne
	@JoinColumn(name="romance_character_id")
	private  RomanceCharacterEntity romanceCharacterId;
	
	// 引数なしのコンストラクタ
	public SavedCharacterStoryEntity(){
		
	}
	
	// 引数ありのコンストラクタ
	public SavedCharacterStoryEntity(Integer chapterNumber, SaveEntity saveId, RomanceCharacterEntity romanceCharacterId) {
		this.chapterNumber = chapterNumber;
		this.saveId = saveId;
		this.romanceCharacterId = romanceCharacterId;
		
	}
	
	/**
	 * キャラクターストーリーセーブ用IDのゲッター
	 * @return
	 */
	public Integer getSavedCharacterStoryId() {
		return savedCharacterStoryId;
	}
	
	/**
	 * キャラクターストーリーセーブ用IDのセッター
	 * @param savedCharacterStoryId
	 */
	public void setSavedCharacterStoryId(Integer savedCharacterStoryId) {
		this.savedCharacterStoryId = savedCharacterStoryId;
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
	
	/**
	 * キャラクターID外部キーのセッター
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
