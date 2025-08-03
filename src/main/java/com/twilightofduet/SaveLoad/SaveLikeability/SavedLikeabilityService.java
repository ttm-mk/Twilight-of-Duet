package com.twilightofduet.SaveLoad.SaveLikeability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.Character.RomanceCharacterRepository;
import com.twilightofduet.Likeability.LikeabilityEntity;
import com.twilightofduet.Likeability.LikeabilityRepository;
import com.twilightofduet.SaveLoad.SaveFunction.SaveEntity;
import com.twilightofduet.User.UserCommon.UsersEntity;

/**
 * SaveLoadServiceコントローラ
 * 作成者 tsutsumi miki
 * 編集日 2025/7/31 tsutsumi miki
 */

@Service
public class SavedLikeabilityService {
	
	@Autowired
	SavedLikeabilityRepository savedLikeabilityRepository;
	@Autowired
	LikeabilityRepository likeabilityReposiotry;
	@Autowired
	RomanceCharacterRepository characterRepository;
	
	/**
	 * 好感度セーブ機能
	 * @param saveEntity
	 * @return
	 */
	public String saveLikeability(SaveEntity saveEntity) {
		
		if(saveEntity == null || saveEntity.getSaveId() == null) {
			throw new RuntimeException("saveEntityが空なので好感度を保存できません。");

		}
		
		// 一人一人の好感度引き出して格納する
		UsersEntity userEntity = saveEntity.getUserId();
		LikeabilityEntity takumiEntity = likeabilityReposiotry.findByUserIdAndRomanceCharacterId(userEntity, characterRepository.findByCharacterName("園山巧美"));
		Integer takumiLikeability = takumiEntity.getCharacterLikeability();
		
		LikeabilityEntity somaEntity = likeabilityReposiotry.findByUserIdAndRomanceCharacterId(userEntity, characterRepository.findByCharacterName("小早川颯真"));
		Integer somaLikeability = somaEntity.getCharacterLikeability();
		
		LikeabilityEntity miyukiEntity = likeabilityReposiotry.findByUserIdAndRomanceCharacterId(userEntity, characterRepository.findByCharacterName("須王御幸"));
		Integer miyukiLikeability = miyukiEntity.getCharacterLikeability();
		
		LikeabilityEntity takutoEntity = likeabilityReposiotry.findByUserIdAndRomanceCharacterId(userEntity, characterRepository.findByCharacterName("園山巧斗"));
		Integer takutoLikeability = takutoEntity.getCharacterLikeability();
		
		LikeabilityEntity miruEntity = likeabilityReposiotry.findByUserIdAndRomanceCharacterId(userEntity, characterRepository.findByCharacterName("相良実瑠"));
		Integer miruLikeability = miruEntity.getCharacterLikeability();
		
		try {
			savedLikeabilityRepository.save(new SavedLikeabilityEntity(takumiLikeability, saveEntity, characterRepository.findByCharacterName("園山巧美")));
			savedLikeabilityRepository.save(new SavedLikeabilityEntity(somaLikeability, saveEntity, characterRepository.findByCharacterName("小早川颯真")));
			savedLikeabilityRepository.save(new SavedLikeabilityEntity(miyukiLikeability, saveEntity, characterRepository.findByCharacterName("須王御幸")));
			savedLikeabilityRepository.save(new SavedLikeabilityEntity(takutoLikeability, saveEntity, characterRepository.findByCharacterName("園山巧斗")));
			savedLikeabilityRepository.save(new SavedLikeabilityEntity(miruLikeability, saveEntity, characterRepository.findByCharacterName("相良実瑠")));

		} catch(Exception e) {
			throw new RuntimeException("好感度のセーブに失敗しました", e);
			
		}
		
		return "ok";
		
	}
	
	/**
	 * 更新用好感度セーブ機能
	 * @param saveEntity
	 * @return
	 */
	public String updateLikeability(SaveEntity saveEntity) {
		// ユーザーEntity取得
		UsersEntity userEntity = saveEntity.getUserId();
		
		if(saveEntity == null || saveEntity.getSaveId() == null) {
			throw new RuntimeException("saveEntityが空なので好感度を保存できません。");

		}
		
		// 一人一人の好感度引き出して格納する
		RomanceCharacterEntity takumiEntity = characterRepository.findByCharacterName("園山巧美");
		// 好感度の取得
		LikeabilityEntity takumiLikeabilityEntity = 
				likeabilityReposiotry.findByUserIdAndRomanceCharacterId(userEntity, takumiEntity);
		Integer takumiLikeability = takumiLikeabilityEntity.getCharacterLikeability();
		// セーブ用好感度Entity取得
		SavedLikeabilityEntity takumiSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, takumiEntity);
		// 好感度をセット
		takumiSaveLikeabilityEntity.setLikeabilityNumber(takumiLikeability);
		// TODO:以下上記内容に変更する
		
		RomanceCharacterEntity somaEntity = characterRepository.findByCharacterName("小早川颯真");
		LikeabilityEntity somaLikeabilityEntity = 
				likeabilityReposiotry.findByUserIdAndRomanceCharacterId(userEntity, somaEntity);
		Integer somaLikeability = somaLikeabilityEntity.getCharacterLikeability();
		SavedLikeabilityEntity somaSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, somaEntity);
		somaSaveLikeabilityEntity.setLikeabilityNumber(somaLikeability);
		
		RomanceCharacterEntity miyukiEntity = characterRepository.findByCharacterName("須王御幸");
		LikeabilityEntity miyukiLikeabilityEntity = 
				likeabilityReposiotry.findByUserIdAndRomanceCharacterId(userEntity, miyukiEntity);
		Integer miyukiLikeability = miyukiLikeabilityEntity.getCharacterLikeability();
		SavedLikeabilityEntity miyukiSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, miyukiEntity);
		miyukiSaveLikeabilityEntity.setLikeabilityNumber(miyukiLikeability);
		
		RomanceCharacterEntity takutoEntity = characterRepository.findByCharacterName("園山巧斗");
		LikeabilityEntity takutoLikeabilityEntity = 
				likeabilityReposiotry.findByUserIdAndRomanceCharacterId(userEntity, takutoEntity);
		Integer takutoLikeability = takutoLikeabilityEntity.getCharacterLikeability();
		SavedLikeabilityEntity takutoSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, takutoEntity);
		takutoSaveLikeabilityEntity.setLikeabilityNumber(takutoLikeability);
		
		RomanceCharacterEntity miruEntity = characterRepository.findByCharacterName("相良実瑠");
		LikeabilityEntity miruLikeabilityEntity = 
				likeabilityReposiotry.findByUserIdAndRomanceCharacterId(userEntity, miruEntity);
		Integer miruLikeability = miruLikeabilityEntity.getCharacterLikeability();
		SavedLikeabilityEntity miruSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, miruEntity);
		miruSaveLikeabilityEntity.setLikeabilityNumber(miruLikeability);
		
		try {
			savedLikeabilityRepository.save(takumiSaveLikeabilityEntity);
			savedLikeabilityRepository.save(somaSaveLikeabilityEntity);
			savedLikeabilityRepository.save(miyukiSaveLikeabilityEntity);
			savedLikeabilityRepository.save(takutoSaveLikeabilityEntity);
			savedLikeabilityRepository.save(miruSaveLikeabilityEntity);

		} catch(Exception e) {
			throw new RuntimeException("好感度のセーブに失敗しました", e);
			
		}
		
		return "ok";
		
	}

}
