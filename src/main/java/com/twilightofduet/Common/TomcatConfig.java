package com.twilightofduet.Common;

import java.util.Collections;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.SessionTrackingMode;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TomcatConfigration
 * 作成者 tsutsumi miki
 * 編集日 2025/5/10 tsutsumi miki
 */

@Configuration
public class TomcatConfig {
	
	@Bean
    public ServletContextInitializer servletContextInitializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));
            }
        };
    }

}
