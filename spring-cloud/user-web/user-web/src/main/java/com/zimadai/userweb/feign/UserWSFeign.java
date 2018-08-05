package com.zimadai.userweb.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zimadai.user.response.UserResponse;


@FeignClient(value = "user-service")
@RequestMapping(value = "/api-user")
public interface UserWSFeign {
	@RequestMapping(value = "/user/deleteWS", method = RequestMethod.GET)
	public int deleteUser(@RequestParam(value = "id") Integer id);

	@RequestMapping(value = "/user/findUserByPageWS", method = RequestMethod.GET)
	public List<UserResponse> findUserByPage(@RequestParam(value = "pageNow")Integer pageNow,
			@RequestParam(value = "pageSize")Integer pageSize);
}
