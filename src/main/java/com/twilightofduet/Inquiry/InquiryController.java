package com.twilightofduet.Inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * InquiryController
 * 作成者 tsutsumi miki
 * 編集日 2025/1/19 tsutsumi miki
 */

@Controller
public class InquiryController {
	
	/**
	 * お問い合わせフォーム画面
	 * @return
	 */
	@GetMapping("/inquiry")
	public String inquiryDisplay() {
		return "/inquiry/inquiry_form";
	}
	
	/**
	 * 記載内容確認画面に遷移
	 * 
	 * @param inquiryForm　お問い合わせフォームクラス
	 * @param model　モデルクラス
	 * @return　内容確認画面
	 */
	@PostMapping("/inquiry/confirm")
	public String inquiryConfirmDisplay(InquiryForm inquiryForm, Model model) {
		/* ユーザー名出力 */
		model.addAttribute("InquiryUserName", inquiryForm.getInquiryUserName());
		/* お問い合わせ内容出力 */
		model.addAttribute("InquiryText", inquiryForm.getInquiryText());
		return "/inquiry/inquiry_confirm";

	}
	
	@PostMapping("/inquiry/submit")
	public String inquirySubmit(@ModelAttribute InquiryForm inquiryForm, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", "送信しました。ご意見ありがとうございました。");
		return "redirect:/inquiry";
	}

}
