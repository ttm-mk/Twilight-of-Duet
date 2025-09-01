package com.twilightofduet;

/**
 * TODApplication
 * 作成者 tsutsumi miki
 * 編集日 2025/9/2 tsutsumi miki
 */

import java.util.TimeZone;

import jakarta.annotation.PostConstruct;

/**
 * ApplicationController
 * 作成者 tsutsumi miki
 * 編集日 2025/7/30 tsutsumi miki
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TwilightOfDuetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwilightOfDuetApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("JST"));
	}

}
