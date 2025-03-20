package com.twilightofduet.Gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * GalleryService
 * 作成者 tsutsumi miki
 * 編集日 2025/3/20 tsutsumi miki
 */

@Service
public class GalleryService {
	
	@Autowired
	GalleryRepository galleryRepository;
	
	public GalleryEntity galleryCreate() {
		
		GalleryEntity galleryEntity = new GalleryEntity();
		galleryEntity.setMainStory(0);
		galleryEntity.setTakumiStory(0); 
		galleryEntity.setSomaStory(0); 
		galleryEntity.setMiyukiStory(0); 
		galleryEntity.setTakutoStory(0); 
		galleryEntity.setMiruStory(0); 
		galleryEntity.setMainStill(0);
		galleryEntity.setTakumiStill(0); 
		galleryEntity.setSomaStill(0); 
		galleryEntity.setMiyukiStill(0); 
		galleryEntity.setTakutoStill(0); 
		galleryEntity.setMiruStill(0); 
		galleryEntity = galleryRepository.save(galleryEntity);
		
		return galleryEntity;

		
	}

}
