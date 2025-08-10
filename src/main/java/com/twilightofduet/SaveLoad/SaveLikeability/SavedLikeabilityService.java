package com.twilightofduet.SaveLoad.SaveLikeability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.Character.RomanceCharacterRepository;
import com.twilightofduet.Likeability.LikeabilityEntity;
import com.twilightofduet.Likeability.LikeabilityRepository;
import com.twilightofduet.SaveLoad.SaveFunction.SaveEntity;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

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
	LikeabilityRepository likeabilityRepository;
	@Autowired
	RomanceCharacterRepository characterRepository;
	@Autowired
	UsersRepository userRepository;

	
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
		LikeabilityEntity takumiEntity = likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, characterRepository.findByCharacterName("園山巧美"));
		Integer takumiLikeability = takumiEntity.getCharacterLikeability();
		
		LikeabilityEntity somaEntity = likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, characterRepository.findByCharacterName("小早川颯真"));
		Integer somaLikeability = somaEntity.getCharacterLikeability();
		
		LikeabilityEntity miyukiEntity = likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, characterRepository.findByCharacterName("須王御幸"));
		Integer miyukiLikeability = miyukiEntity.getCharacterLikeability();
		
		LikeabilityEntity takutoEntity = likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, characterRepository.findByCharacterName("園山巧斗"));
		Integer takutoLikeability = takutoEntity.getCharacterLikeability();
		
		LikeabilityEntity miruEntity = likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, characterRepository.findByCharacterName("相良実瑠"));
		Integer miruLikeability = miruEntity.getCharacterLikeability();
		
		try {
			savedLikeabilityRepository.save(new SavedLikeabilityEntity(takumiLikeability, saveEntity, characterRepository.findByCharacterName("園山巧美")));
			savedLikeabilityRepository.save(new SavedLikeabilityEntity(somaLikeability, saveEntity, characterRepository.findByCharacterName("小早川颯真")));
			savedLikeabilityRepository.save(new SavedLikeabilityEntity(miyukiLikeability, saveEntity, characterRepository.findByCharacterName("須王御幸")));
			savedLikeabilityRepository.save(new SavedLikeabilityEntity(takutoLikeability, saveEntity, characterRepository.findByCharacterName("園山巧斗")));
			savedLikeabilityRepository.save(new SavedLikeabilityEntity(miruLikeability, saveEntity, characterRepository.findByCharacterName("相良実瑠")));

			return "ok";
			
		} catch(Exception e) {
			throw new RuntimeException("好感度のセーブに失敗しました", e);
			
		}
		
		
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
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, takumiEntity);
		Integer takumiLikeability = takumiLikeabilityEntity.getCharacterLikeability();
		// セーブ用好感度Entity取得
		SavedLikeabilityEntity takumiSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, takumiEntity);
		// 好感度をセット
		takumiSaveLikeabilityEntity.setLikeabilityNumber(takumiLikeability);
		// TODO:以下上記内容に変更する
		
		RomanceCharacterEntity somaEntity = characterRepository.findByCharacterName("小早川颯真");
		LikeabilityEntity somaLikeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, somaEntity);
		Integer somaLikeability = somaLikeabilityEntity.getCharacterLikeability();
		SavedLikeabilityEntity somaSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, somaEntity);
		somaSaveLikeabilityEntity.setLikeabilityNumber(somaLikeability);
		
		RomanceCharacterEntity miyukiEntity = characterRepository.findByCharacterName("須王御幸");
		LikeabilityEntity miyukiLikeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, miyukiEntity);
		Integer miyukiLikeability = miyukiLikeabilityEntity.getCharacterLikeability();
		SavedLikeabilityEntity miyukiSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, miyukiEntity);
		miyukiSaveLikeabilityEntity.setLikeabilityNumber(miyukiLikeability);
		
		RomanceCharacterEntity takutoEntity = characterRepository.findByCharacterName("園山巧斗");
		LikeabilityEntity takutoLikeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, takutoEntity);
		Integer takutoLikeability = takutoLikeabilityEntity.getCharacterLikeability();
		SavedLikeabilityEntity takutoSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, takutoEntity);
		takutoSaveLikeabilityEntity.setLikeabilityNumber(takutoLikeability);
		
		RomanceCharacterEntity miruEntity = characterRepository.findByCharacterName("相良実瑠");
		LikeabilityEntity miruLikeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, miruEntity);
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

			return "ok";
			
		} catch(Exception e) {
			throw new RuntimeException("好感度のセーブに失敗しました", e);
			
		}
		
		
	}
	
	public String uploadLikeability(SaveEntity saveEntity) {
		// UserEntityの取得
		UsersEntity userEntity = saveEntity.getUserId();
		
		// saveEntityから各キャラクターの好感度を取得し、UserEntityに紐づいているLikeabilityレコードにセット
		
		// 一人一人の好感度引き出して格納する
		RomanceCharacterEntity takumiEntity = characterRepository.findByCharacterName("園山巧美");
		// セーブ用好感度Entityを取得し、セーブEntity内の好感度を取得・格納
		SavedLikeabilityEntity takumiSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, takumiEntity);
		Integer takumiLikeability = takumiSaveLikeabilityEntity.getLikeabilityNumber();
		// UserEntityに紐づくLikeabilityEntityを取得
		LikeabilityEntity takumiLikeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, takumiEntity);
		// 好感度をセット
		takumiLikeabilityEntity.setCharacterLikeability(takumiLikeability);

		// 以下キャラクターで同処理を実施
		// 小早川颯真の処理
		RomanceCharacterEntity somaEntity = characterRepository.findByCharacterName("小早川颯真");
		SavedLikeabilityEntity somaSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, somaEntity);
		Integer somaLikeability = somaSaveLikeabilityEntity.getLikeabilityNumber();
		LikeabilityEntity somaLikeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, somaEntity);
		somaLikeabilityEntity.setCharacterLikeability(somaLikeability);
		
		// 須王御幸の処理
		RomanceCharacterEntity miyukiEntity = characterRepository.findByCharacterName("須王御幸");
		SavedLikeabilityEntity miyukiSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, miyukiEntity);
		Integer miyukiLikeability = miyukiSaveLikeabilityEntity.getLikeabilityNumber();
		LikeabilityEntity miyukiLikeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, miyukiEntity);
		miyukiLikeabilityEntity.setCharacterLikeability(miyukiLikeability);
		
		// 園山巧斗の処理
		RomanceCharacterEntity takutoEntity = characterRepository.findByCharacterName("園山巧斗");
		SavedLikeabilityEntity takutoSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, takutoEntity);
		Integer takutoLikeability = takutoSaveLikeabilityEntity.getLikeabilityNumber();
		LikeabilityEntity takutoLikeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, takutoEntity);
		takutoLikeabilityEntity.setCharacterLikeability(takutoLikeability);
		
		// 相良実瑠の処理
		RomanceCharacterEntity miruEntity = characterRepository.findByCharacterName("相良実瑠");
		SavedLikeabilityEntity miruSaveLikeabilityEntity = 
				savedLikeabilityRepository.findBySaveIdAndRomanceCharacterId(saveEntity, miruEntity);
		Integer miruLikeability = miruSaveLikeabilityEntity.getLikeabilityNumber();
		LikeabilityEntity miruLikeabilityEntity = 
				likeabilityRepository.findByUserIdAndRomanceCharacterId(userEntity, miruEntity);
		miruLikeabilityEntity.setCharacterLikeability(miruLikeability);
		
		
		// で保存
		try {
			likeabilityRepository.save(takumiLikeabilityEntity);
			likeabilityRepository.save(somaLikeabilityEntity);
			likeabilityRepository.save(miyukiLikeabilityEntity);
			likeabilityRepository.save(takutoLikeabilityEntity);
			likeabilityRepository.save(miruLikeabilityEntity);

			return "ok";
			
		} catch(Exception e) {
			throw new RuntimeException("好感度のロードに失敗しました", e);
			
		}
		
	}

}
