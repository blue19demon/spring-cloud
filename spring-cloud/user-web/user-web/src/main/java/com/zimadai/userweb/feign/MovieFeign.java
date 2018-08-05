package com.zimadai.userweb.feign;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "movie-service")
@RequestMapping(value = "/api-movie")
public interface MovieFeign {
	@RequestMapping(value = "/movie/add", method = RequestMethod.GET)
	public int addMovie(@RequestParam(value = "name") String name,
			@RequestParam(value = "price") BigDecimal price);

	@RequestMapping(value = "/movie/all", method = RequestMethod.GET)
	public Object findAll();
}
