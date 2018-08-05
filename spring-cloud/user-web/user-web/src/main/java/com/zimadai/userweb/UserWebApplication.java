package com.zimadai.userweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableFeignClients
public class UserWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserWebApplication.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "HELLO";
	}
}
