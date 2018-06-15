package com.jeff.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户服务接口
 * Created by Jeff on 2018/6/14.
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @GetMapping("test")
    public String test(){
        return "this is a test!";
    }
}
