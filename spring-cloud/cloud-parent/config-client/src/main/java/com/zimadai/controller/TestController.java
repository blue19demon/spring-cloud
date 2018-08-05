package com.zimadai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zimadai.domain.JdbcFile;

@RestController
public class TestController {
	@Autowired
	private JdbcFile jdbcConfig;
	
	@GetMapping("conf/jdbc")
	public JdbcFile jdbc() {
		return jdbcConfig;
	}
}
