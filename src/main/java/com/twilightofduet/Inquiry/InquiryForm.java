package com.twilightofduet.Inquiry;

/*
 * InquiryForm
 * 作成者 tsutsumi miki
 * 編集日 2025/1/21 tsutsumi miki
 */

public class InquiryForm {
	
	/* お問い合わせユーザー名 */
	private String InquiryUserName;
	
	/* お問い合わせ内容 */
	private String InquiryText;

	/**
	 * お問い合わせユーザー名のGetter
	 * @return
	 */
	public String getInquiryUserName() {
		return InquiryUserName;
	}

	/**
	 * お問い合わせユーザー名のSetter
	 * @param inquiryUserName
	 */
	public void setInquiryUserName(String inquiryUserName) {
		this.InquiryUserName = inquiryUserName;
	}

	/**
	 * お問い合わせ内容のGetter
	 * @return
	 */
	public String getInquiryText() {
		return InquiryText;
	}

	/**
	 * お問い合わせ内容のSetter
	 * @param inquiryText
	 */
	public void setInquiryText(String inquiryText) {
		this.InquiryText = inquiryText;
	}
	
	

}
