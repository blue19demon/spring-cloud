package com.zimadai.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zimadai.cloud.bean.User;
import com.zimadai.cloud.mapper.UserMapper;
import com.zimadai.user.response.UserResponse;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        //PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }

	@Override
	public int deleteUser(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<UserResponse> findUserByPage(Integer pageNow, Integer pageSize) {
		Integer start=(pageNow-1)*pageSize+1;
		return userMapper.findUserByPage(start,pageSize);
	}
}