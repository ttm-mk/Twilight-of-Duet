package com.twilightofduet.Screan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * SummaryController
 * 作成者 tsutsumi miki
 * 編集日 2025/1/19 tsutsumi miki
 */

@Controller
public class SummaryController {
	
	@GetMapping("/summary")
	public String summaryDisplay() {
		return "/summary/summary_top";
	}

}
