package com.pking.feigns;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pking.entity.MoUser;

@Service
@FeignClient("pking-provider02")
public interface IUserService02 {
	
    @GetMapping("/db/list")
    List<MoUser> getListFromDB();
    
    @GetMapping("/redis/set")
    public String set2Redis(@RequestParam(value = "key") String key,@RequestParam(value ="value") String value);
    
    @GetMapping("/redis/get")
	public String getFromRedis(@RequestParam(value = "key") String key);
}