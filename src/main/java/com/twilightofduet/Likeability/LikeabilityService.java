package com.twilightofduet.Likeability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * LikeabilityService
 * 作成者 tsutsumi miki
 * 編集日 2025/3/17 tsutsumi miki
 */

@Service
public class LikeabilityService {
	@Autowired
	LikeabilityRepository likeabilityRepository;
	
	public LikeabilityEntity likeabilityCreate() {
		
		LikeabilityEntity likeabilityEntity = new LikeabilityEntity();
		likeabilityEntity.setTakumiLikeability(0); 
		likeabilityEntity.setSomaLikeability(0); 
		likeabilityEntity.setMiyukiLikeability(0); 
		likeabilityEntity.setTakutoLikeability(0); 
		likeabilityEntity.setMiruLikeability(0); 
		likeabilityEntity = likeabilityRepository.save(likeabilityEntity);
		
		return likeabilityEntity;

		
	}

}
