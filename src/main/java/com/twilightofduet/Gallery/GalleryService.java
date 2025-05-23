package com.twilightofduet.Gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.Character.RomanceCharacterRepository;
import com.twilightofduet.User.UserCommon.UsersEntity;

/*
 * GalleryService
 * 作成者 tsutsumi miki
 * 編集日 2025/5/23 tsutsumi miki
 */

@Service
public class GalleryService {
	// TODO:Autowiredじゃなくてprivate final...で引数入れたコンストラクタで作成
	// TODO:Constantsでキャラクター名を定数で定義して使用する
	@Autowired
	GalleryRepository galleryRepository;
	@Autowired
	RomanceCharacterRepository romanceCharacterRepository;
	
	public String galleryCreate(UsersEntity user) {
		
		if(user == null || user.getUserId() == null){ 
			throw new RuntimeException("ユーザー名が空なのでギャラリーを作成できません。");
			
		}
		
		try {
			// メインEntity取得
			RomanceCharacterEntity mainEntity = romanceCharacterRepository.findByCharacterName("メイン");
			// 園山巧美Entity取得
			RomanceCharacterEntity takumiEntity = romanceCharacterRepository.findByCharacterName("園山巧美");
			// 小早川颯真Entity取得
			RomanceCharacterEntity somaEntity = romanceCharacterRepository.findByCharacterName("小早川颯真");
			// 須王御幸Entity取得
			RomanceCharacterEntity miyukiEntity = romanceCharacterRepository.findByCharacterName("須王御幸");
			// 園山巧斗Entity取得
			RomanceCharacterEntity takutoEntity = romanceCharacterRepository.findByCharacterName("園山巧斗");
			// 相良実瑠Entity取得
			RomanceCharacterEntity miruEntity = romanceCharacterRepository.findByCharacterName("相良実瑠");
			
			// 各ギャラリー保存
			galleryRepository.save(new GalleryEntity(0, 0, user, mainEntity));
			galleryRepository.save(new GalleryEntity(0, 0, user, takumiEntity));
			galleryRepository.save(new GalleryEntity(0, 0, user, somaEntity));
			galleryRepository.save(new GalleryEntity(0, 0, user, miyukiEntity));
			galleryRepository.save(new GalleryEntity(0, 0, user, takutoEntity));
			galleryRepository.save(new GalleryEntity(0, 0, user, miruEntity));
			
		} catch(Exception e) {
			throw new RuntimeException("ギャラリーの作成に失敗しました。", e);
			
		}
		
		return "ok";

		
	}

}
