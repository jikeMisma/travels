package com.mypj.test;

import com.mypj.TravelsApplication;
import com.mypj.entity.User;
import com.mypj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mazhicheng
 * @date 2020/6/5 - 21:56
 */
@SpringBootTest(classes = TravelsApplication.class)
@RunWith(SpringRunner.class)
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){

        User user = new User();
        user.setUsername("小马儿");
        user.setPassword("111111");
        user.setEmail("2889479657@qq.com");
        userService.regester(user);
    }
}
