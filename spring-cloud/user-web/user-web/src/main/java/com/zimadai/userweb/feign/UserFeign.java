package com.zimadai.userweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
@RequestMapping(value = "/api-user")
public interface UserFeign {
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public int addUser(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password, @RequestParam(value = "phone") String phone);

	@RequestMapping(value = "/user/all/{pageNum}/{pageSize}", method = RequestMethod.GET)
	public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize);
}
