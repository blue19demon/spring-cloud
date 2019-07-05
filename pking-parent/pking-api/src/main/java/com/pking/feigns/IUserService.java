package com.pking.feigns;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.pking.entity.MoUser;

@Service
@FeignClient("pking-provider")
public interface IUserService {
    @GetMapping("/list")
    List<MoUser> getList();
}