package com.pking.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.pking.entity.MoUser;
import com.pking.feigns.IUserService;

@RestController
public class UserController implements IUserService{

    @Value("${server.port}")
    private int port;

    @Override
    public List<MoUser> getList() {

        return new ArrayList<MoUser>() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			{
                add(new MoUser(1, "shenniu001_" + port));
                add(new MoUser(2, "shenniu002_" + port));
                add(new MoUser(3, "shenniu003_" + port));
            }
        };
    }
}