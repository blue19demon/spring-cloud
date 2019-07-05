package com.elk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

@RestController
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;
    @GetMapping("/index")
    public Object index() {
        for (int i = 0; i < 100; i++) {
            logger.debug("debug" + i);
            logger.info("info" + i);
            logger.warn("warn" + i);
            logger.error("error" + i);
        }

        return "success";
    }
    
    @GetMapping("/regist")
    public Object regist(RequestData requestData) {
    	logger.info("用户注册，请求参数:"+JSON.toJSONString(requestData,true));
    	String res = userService.save(requestData);
    	logger.info("save返回:"+JSON.toJSONString(requestData,true));
        return res;
    }
}