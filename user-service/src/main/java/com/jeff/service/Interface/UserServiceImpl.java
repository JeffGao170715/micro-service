package com.jeff.service.Interface;

import com.jeff.dao.UserMapper;
import com.jeff.model.User;
import com.jeff.service.impl.UserService;
import com.jeff.utils.redis.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务的实现类
 * Created by Jeff on 2018/6/25.
 */
@Service
public class UserServiceImpl implements UserService{
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long add(User user) {
        return Long.valueOf(userMapper.insert(user));
    }

    @Override
    @RedisCache(key = "test_user", expired = 30)
    public User findById(Long uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    @RedisCache(key = "inset_user", read = false, expired = 180)
    public void add2(User user) {
        userMapper.insert(user);
    }
}
