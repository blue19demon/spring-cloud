package com.zimadai.userweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zimadai.userweb.feign.MovieFeign;
import com.zimadai.userweb.feign.UserFeign;

@RestController
public class DataController {
	@Autowired
	private UserFeign userFeign;
	@Autowired
	private MovieFeign movieFeign;

	@GetMapping("/userData")
	public Object userData() {
		return userFeign.findAllUser(1, 22);
	}
	
	@GetMapping("/movieData")
	public Object movieData() {
		return movieFeign.findAll();
	}
}
