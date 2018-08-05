package com.zimadai.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zimadai.cloud.bean.User;
import com.zimadai.cloud.service.UserService;
import com.zimadai.cloud.ws.UserWSLocalService;
import com.zimadai.user.response.UserResponse;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserWSLocalService userWSLocalService;
    
    
    @ResponseBody
    @RequestMapping(value = "/deleteWS", produces = {"application/json;charset=UTF-8"})
    public int deleteUserWS(Integer id){
        return userWSLocalService.deleteUser(id);
    }

    @ResponseBody
    @RequestMapping(value = "/findUserByPageWS", produces = {"application/json;charset=UTF-8"})
    public List<UserResponse> findUserByPageWS(Integer pageNow, Integer pageSize){
        return userWSLocalService.findUserByPage(pageNow,pageSize);
    }

    
    
    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }
}