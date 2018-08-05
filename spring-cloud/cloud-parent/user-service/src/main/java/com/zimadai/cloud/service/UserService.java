package com.zimadai.cloud.service;

import java.util.List;

import com.zimadai.cloud.bean.User;
import com.zimadai.user.response.UserResponse;

public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

	int deleteUser(Integer id);

	List<UserResponse> findUserByPage(Integer pageNow, Integer pageSize);
}
