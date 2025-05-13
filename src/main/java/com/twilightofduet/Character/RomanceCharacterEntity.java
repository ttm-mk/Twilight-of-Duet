package com.twilightofduet.Character;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * RomanceCharacterエンティティ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/13 tsutsumi miki
 */

@Entity
@Table(name="RomanceCharacter")
public class RomanceCharacterEntity {
	
	/* キャラクターID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_romance_character_gen")
	@SequenceGenerator(name = "seq_romance_character_gen", sequenceName = "seq_romance_character", allocationSize = 1)
	private Integer romanceCharacterId;
	
	// キャラクター名
	@Column
	private String characterName;
	
	// コンストラクタ（引数なし）
	public RomanceCharacterEntity() {
		
	}
	
	// コンストラクタ（引数あり）
	public RomanceCharacterEntity(String name) {
		this.setCharacterName(name);
	}

	/**
	 * キャラクターIDのゲッター
	 * 
	 * @return
	 */
	public Integer getRomanceCharacterId() {
		return romanceCharacterId;
	}

	/**
	 * キャラクターIDのセッター
	 * 
	 * @param romanceCharacterId
	 */
	public void setRomanceCharacterId(Integer romanceCharacterId) {
		this.romanceCharacterId = romanceCharacterId;
	}

	/**
	 * キャラクター名のゲッター
	 * 
	 * @return
	 */
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * キャラクター名のセッター
	 * 
	 * @param characterName
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	
	
	
	

}
