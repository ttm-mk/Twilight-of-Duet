package com.twilightofduet.Likeability;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LikeabilityRestController
 * 作成者 tsutsumi miki
 * 編集日 2025/5/4 tsutsumi miki
 */

@RestController
@RequestMapping("/api/likeability")
public class LikeabilityRestController {
	
	@Autowired
	LikeabilityService likeabilityService;
	
	/**
	 * JSから好感度を取得し、saveLikeabilityに値を渡して戻り値を受け取る
	 * 
	 * @param likeabilityDTO　好感度DTO
	 * @param storyDTO　ストーリーDTO
	 * @param session　セッション情報
	 * @return　ResponseEntity
	 */
	@PostMapping("/add")
	public ResponseEntity<Integer> saveLikeabilityInt(@RequestBody LikeabilityRequestDTO likeabilityRequestDTO, HttpSession session){
		
		// 好感度をJSから取得し、コントローラに渡す
		// TODO：ストーリータイプでメソッド分岐させたい
		Integer responseInt = likeabilityService.saveLikeability(likeabilityRequestDTO, session);
		
		if(likeabilityRequestDTO != null) {
			return ResponseEntity.ok(responseInt);
			
		} else {
			return ResponseEntity.notFound().build();
			
		}
		
	}

}
