package com.mypj.Dao;

import com.mypj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mazhicheng
 * @date 2020/6/5 - 21:41
 */
@Mapper
public interface UserDao {

    //根据用户名查询用户
    User findByUsername(String username);

    //注册用户
    void save(User user);
}
