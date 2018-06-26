package com.jeff.api;

import com.jeff.model.User;
import com.jeff.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户服务接口
 * Created by Jeff on 2018/6/14.
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("test.json")
    public String test(){
        logger.info("<===123214325====>");
        return "this is a test!";
    }

    @GetMapping("find.json")
    public User find(@RequestParam Long uid){
        return userService.findById(uid);
    }


    @PostMapping("add.json")
    public boolean addUser(@RequestBody User user){
        userService.add2(user);

        return true;
    }
}
