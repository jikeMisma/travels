package com.mypj.service.impl;

import com.mypj.Dao.UserDao;
import com.mypj.entity.User;
import com.mypj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mazhicheng
 * @date 2020/6/5 - 21:50
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {

        User userDb = userDao.findByUsername(user.getUsername());
        if(userDb != null){

            if(userDb.getPassword().equals(user.getPassword())){
                return userDb;
            }
            throw  new RuntimeException("密码输入错误！！！");
        }else{
            throw  new RuntimeException("用户名输入错误！！！");
        }
    }

    @Override
    public void regester(User user) {

        if(userDao.findByUsername(user.getUsername())==null) {
            userDao.save(user);
        }else{
            throw  new RuntimeException("用户名已存在！");
        }


    }
}
