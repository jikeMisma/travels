package com.mypj.controller;

import com.mypj.entity.Result;
import com.mypj.entity.User;
import com.mypj.service.UserService;
import com.mypj.utils.CreateImageCode;
import com.mypj.utils.ValidateImageCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mazhicheng
 * @date 2020/6/5 - 20:26
 */

@RestController
@RequestMapping("user")
@CrossOrigin//允许跨域
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    public Result login(@RequestBody User user,HttpServletRequest request){

        Result result=new Result();
        log.info("user"+user);
        try{
            User userDB = userService.login(user);
            //登录成功之后保存用户标记,直接将全局作用域放到applicationContext占用过多的服务器资源，不可选
            //应该使用redis对用户的id进行缓存
            request.getServletContext().setAttribute(userDB.getId(),userDB);
            result.setMag("登录成功！").setUserId(userDB.getId());
        }catch (Exception e){
            result.setStates(false).setMag(e.getMessage());
        }

        return result;
    }


    /**
     * 用户注册
     * @param code
     * @param user
     * @return
     */
    @PostMapping("register")
    public Result regiter(String code, String key, @RequestBody User user, HttpServletRequest request){

        Result result = new Result();

        log.info("接收的验证码"+code);
        log.info("接收的user对象"+user);
        log.info("接收的key"+key);
        //验证码
        String keyCode = (String) request.getServletContext().getAttribute(key);
        log.info(keyCode);
        try{
        if(code.equalsIgnoreCase(keyCode)){
            //注册用户

                userService.regester(user);
                result.setMag("注册成功！");



        }else{
            throw new RuntimeException("验证码有误！！！");
        }
        }catch (Exception e){
            e.printStackTrace();
            result.setMag(e.getMessage()).setStates(false);

        }


        return  result;

    }

    /**
     * 生成验证码
     * @param
     * @param
     * @throws IOException
     */
    @GetMapping("getImage")
    private Map<String,String> getImage(HttpServletRequest request) throws IOException {

        Map<String,String> result=new HashMap<>();
        CreateImageCode createImageCode = new CreateImageCode();
        //1.获取验证码
        String securityCode = createImageCode.getCode();
        //2.验证码存入session
       String key =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
       request.getServletContext().setAttribute(key,securityCode);
        //3.生成图片
        BufferedImage image = createImageCode.getBuffImg();
        //4.进行Base64编码
        ByteArrayOutputStream bos= new ByteArrayOutputStream();
        ImageIO.write(image,"png",bos);
        String string = Base64Utils.encodeToString(bos.toByteArray());
        result.put("key",key);
        result.put("image",string);
        return result;

    }

}
