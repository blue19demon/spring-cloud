package com.zimadai.userweb.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.zimadai.userweb.feign.MovieFeign;
import com.zimadai.userweb.feign.UserFeign;

@Controller
public class PageController {
	//编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    private UserFeign userFeign;
    @Autowired
	private MovieFeign movieFeign;
	@GetMapping("/index")
	public String index() {
		userFeign.addUser("张三", "123456", "18402850503");
		return "index";
	}
	
	@GetMapping("/movieIndex")
	public String movieIndex() {
		movieFeign.addMovie("卧虎藏龙",new BigDecimal(11.2));
		return "movieIndex";
	}
}
