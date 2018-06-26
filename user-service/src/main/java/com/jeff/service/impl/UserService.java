package com.jeff.service.impl;

import com.jeff.model.User;

/**
 * 用户相关业务接口
 * Created by Jeff on 2018/6/25.
 */
public interface UserService {
    /**
     * 新建/添加一个用户
     * @param user  用户信息
     * @return      返回用户ID
     */
    Long add(User user);

    /**
     * 根绝ID查找用户
     * @param uid   用户ID
     * @return  返回用户信息
     */
    User findById(Long uid);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);

    void add2(User user);
}
