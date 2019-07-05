package com.pking.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pking.entity.MoUser;
import com.pking.feigns.IUserService;

@RestController
public class UserController {

    @Autowired
    protected IUserService userService;

    @GetMapping("/list")
    public List<MoUser> getList() {
        return userService.getList();
    }
}