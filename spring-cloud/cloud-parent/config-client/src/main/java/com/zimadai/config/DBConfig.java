package com.zimadai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zimadai.domain.JdbcFile;

@Configuration
public class DBConfig {

	@Bean
	public JdbcFile  jdbcConfig() {
		return new JdbcFile();
	}
}
