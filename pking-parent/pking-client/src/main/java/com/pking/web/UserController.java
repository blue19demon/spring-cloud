package com.pking.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pking.entity.MoUser;
import com.pking.feigns.IUserService;
import com.pking.feigns.IUserService02;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

    @Autowired
    protected IUserService userService;
    @Autowired
    protected IUserService02 userService02;

    @GetMapping("/db/list")
    public List<MoUser> getList() {
    	List<MoUser> getList = userService.getListFromDB();
    	getList.addAll(userService02.getListFromDB());
        return getList;
    }
    
    @RequestMapping(value = "/redis/set/{key}/{value}", method = RequestMethod.GET)
    public String set2Redis(@PathVariable(value ="key") String key,@PathVariable(value ="value") String value) {
    	return userService.set2Redis(key, value);
    }
    
    @RequestMapping(value = "/redis/get/{key}", method = RequestMethod.GET)
	public String getFromRedis(@PathVariable(value ="key") String key) {
    	return userService.getFromRedis(key);
    }
}