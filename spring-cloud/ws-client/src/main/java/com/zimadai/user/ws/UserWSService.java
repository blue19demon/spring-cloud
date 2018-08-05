package com.zimadai.user.ws;

import java.util.List;

import com.zimadai.user.response.UserResponse;

public interface UserWSService {
	
	public int deleteUser(Integer id);

	public List<UserResponse> findUserByPage(Integer pageNow, Integer pageSize);
}
