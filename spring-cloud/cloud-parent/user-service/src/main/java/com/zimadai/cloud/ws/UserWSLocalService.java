package com.zimadai.cloud.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zimadai.cloud.service.UserService;
import com.zimadai.user.response.UserResponse;
import com.zimadai.user.ws.UserWSService;

/**
 * @author Administrator
 *
 */
@Service("userWSLocalService")
public class UserWSLocalService implements UserWSService {
	@Autowired
	private UserService userService;
	@Override
	public int deleteUser(Integer id) {
		return userService.deleteUser(id);
	}

	@Override
	public List<UserResponse> findUserByPage(Integer pageNow, Integer pageSize) {
		return userService.findUserByPage( pageNow,  pageSize);
	}
}
