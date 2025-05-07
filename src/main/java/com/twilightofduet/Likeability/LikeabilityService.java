package com.twilightofduet.Likeability;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.twilightofduet.Story.StoryEntity;
import com.twilightofduet.User.UserCommon.UsersEntity;
import com.twilightofduet.User.UserCommon.UsersRepository;

/*
 * LikeabilityService
 * 作成者 tsutsumi miki
 * 編集日 2025/5/7 tsutsumi miki
 */

@Service
public class LikeabilityService {
	
	@Autowired
	LikeabilityRepository likeabilityRepository;
	@Autowired
	UsersRepository usersRepository;
	
	/**
	 * 好感度テーブル作成時の値入力処理
	 * 
	 * @return　好感度Entity
	 */
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
	
	/**
	 * ストーリーIDがJS＞User情報の時、好感度保存処理を実施する
	 * TODO：ストーリータイプ分岐ができたらメソッド名の変更をする！
	 * 
	 * @param likeabilityDTO　好感度DTO
	 * @param storyDTO　ストーリーDTO
	 * @param session　セッション情報
	 * @return　判断値
	 */
	@PostMapping("/likeability/save")
	public Integer saveLikeability(LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session) {
		// 仮代入用変数のため、保存条件確定後削除
		Integer number;
		
		// ユーザーIDからユーザー情報を取得
		UsersEntity userEntity = usersRepository.findByUserId((Integer)session.getAttribute("userId"));
		// 好感度エンティティを取得
		LikeabilityEntity likeabilityEntity = userEntity.getLikeabilityId();
		// likeabilityEntityから各種取得した好感度を代入
		likeabilityEntity.setTakumiLikeability(likeabilityEntity.getTakumiLikeability() + likeabilityRequestDTO.getTakumiLikeability());
		likeabilityEntity.setSomaLikeability(likeabilityEntity.getSomaLikeability() + likeabilityRequestDTO.getSomaLikeability());
		likeabilityEntity.setMiyukiLikeability(likeabilityEntity.getMiyukiLikeability() + likeabilityRequestDTO.getMiyukiLikeability());
		likeabilityEntity.setTakutoLikeability(likeabilityEntity.getTakutoLikeability() + likeabilityRequestDTO.getTakutoLikeability());
		likeabilityEntity.setMiruLikeability(likeabilityEntity.getMiruLikeability() + likeabilityRequestDTO.getMiruLikeability());
		// ストーリーIDの取得
		StoryEntity storyEntity = userEntity.getStoryId();
		Integer mainStoryNumber = (Integer)storyEntity.getMainStory();
		
		// TODO:ユーザーのストーリーIDがJSから取得したストーリーIDより小さい場合に保存して数値を返す
		if(likeabilityRequestDTO.getStoryNumber() > mainStoryNumber) {
			likeabilityRepository.save(likeabilityEntity);
			return number = 1;
			
		} else { 
			return null;
		}
		
	}

}
