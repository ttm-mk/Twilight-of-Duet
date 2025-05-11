package com.twilightofduet.Character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RomanceCharacterリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/5/11 tsutsumi miki
 */

@Repository
public interface RomanceCharacterRepository extends JpaRepository<RomanceCharacterEntity, Integer> {

}
