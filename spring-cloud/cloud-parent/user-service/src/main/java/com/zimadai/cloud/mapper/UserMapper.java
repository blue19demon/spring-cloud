package com.zimadai.cloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zimadai.cloud.bean.User;
import com.zimadai.user.response.UserResponse;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectAllUser();

	List<UserResponse> findUserByPage(@Param("start")Integer start,@Param("pageSize") Integer pageSize);
}