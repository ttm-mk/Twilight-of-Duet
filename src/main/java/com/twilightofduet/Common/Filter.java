package com.twilightofduet.Common;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

/*
 * Filter
 * 作成者 tsutsumi miki
 * 編集日 2025/3/24 tsutsumi miki
 */

@Component
public class Filter extends HttpFilter {
	
	/**
	 * ログインフィルター
	 */
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	            throws IOException, ServletException{
		// 今リクエスト中のURL情報の取得
		String requestURL = request.getRequestURI();
		// リクエストURLが条件にあっているか確認
		if(requestURL.startsWith("/TwilightOfDuet/user") || requestURL.startsWith("/TwilightOfDuet/save")) {
			// あっていた場合
			// セッションIDの取得
			HttpSession session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			// ユーザーIDの有無確認
			if(userId == null) {
				// 存在しない場合、トップにリダイレクト
				response.sendRedirect("/TwilightOfDuet/");
				return;
				
			} else {
				// 他のフィルターがないか確認
				chain.doFilter(request, response);
			}
			
		} else {
			// 条件外のURLの場合は他のフィルターがないか確認
			chain.doFilter(request, response);
			
		}
		
		
		
	}

}
