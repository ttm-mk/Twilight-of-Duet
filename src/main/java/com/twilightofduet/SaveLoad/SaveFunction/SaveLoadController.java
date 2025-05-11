package com.twilightofduet.SaveLoad.SaveFunction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * SaveLoadController
 * 作成者 tsutsumi miki
 * 編集日 2025/1/19 tsutsumi miki
 */

@Controller
public class SaveLoadController {
	
	@GetMapping("/save")
	public String saveDisplay() {
		// ここでユーザーIDが一緒であるデータを表示できるようにしないといけないね
		// もしユーザーIDがもつスロットナンバーがない場合の表示とかを記載しないといけないのかな
		return "/saveLoad/save";
	}
	
	@GetMapping("/load")
	public String loadDisplay() {
		return "/saveLoad/load";
	}

}
