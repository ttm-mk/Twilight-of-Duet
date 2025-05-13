package com.twilightofduet.Gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.Character.RomanceCharacterRepository;
import com.twilightofduet.User.UserCommon.UsersEntity;

/*
 * GalleryService
 * 作成者 tsutsumi miki
 * 編集日 2025/3/20 tsutsumi miki
 */

@Service
public class GalleryService {
	
	@Autowired
	GalleryRepository galleryRepository;
	@Autowired
	RomanceCharacterRepository romanceCharacterRepository;
	
	public String galleryCreate(UsersEntity userEntity) {
		
		// 園山巧美Entity取得
		RomanceCharacterEntity takumiEntity = romanceCharacterRepository.findByRomanceCharacterId("園山巧美");
		// 小早川颯真Entity取得
		RomanceCharacterEntity somaEntity = romanceCharacterRepository.findByRomanceCharacterId("小早川颯真");
		// 須王御幸Entity取得
		RomanceCharacterEntity miyukiEntity = romanceCharacterRepository.findByRomanceCharacterId("須王御幸");
		// 園山巧斗Entity取得
		RomanceCharacterEntity takutoEntity = romanceCharacterRepository.findByRomanceCharacterId("園山巧斗");
		// 相良実瑠Entity取得
		RomanceCharacterEntity miruEntity = romanceCharacterRepository.findByRomanceCharacterId("相良実瑠");
		
		// 各ギャラリー保存
		galleryRepository.save(new GalleryEntity(0, 0, userEntity, takumiEntity));
		galleryRepository.save(new GalleryEntity(0, 0, userEntity, somaEntity));
		galleryRepository.save(new GalleryEntity(0, 0, userEntity, miyukiEntity));
		galleryRepository.save(new GalleryEntity(0, 0, userEntity, takutoEntity));
		galleryRepository.save(new GalleryEntity(0, 0, userEntity, miruEntity));
		
		return "ok";

		
	}

}
