package com.twilightofduet;

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

}
