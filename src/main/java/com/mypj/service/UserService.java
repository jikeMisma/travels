package com.mypj.service;

import com.mypj.entity.User;

/**
 * @author mazhicheng
 * @date 2020/6/5 - 21:49
 */
public interface UserService {

    User login(User user);

    void regester(User user);
}
