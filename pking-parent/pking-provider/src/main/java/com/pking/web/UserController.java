package com.pking.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pking.entity.MoUser;
import com.pking.feigns.IUserService;
import com.pking.service.UserService;

@RestController
public class UserController implements IUserService {
	@Autowired
	private UserService userService;

	@Override
	public List<MoUser> getListFromDB() {
		return userService.getListFromDB();
	}

	@Override
	public String set2Redis(String key, String value) {
		return userService.set2Redis(key, value);
	}

	@Override
	public String getFromRedis(String key) {
		return userService.getFromRedis(key);
	}
}