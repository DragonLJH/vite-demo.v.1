package com.example.demo.controller;


import com.example.demo.common.User;
import com.example.demo.service.UserSerive;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Api(tags = "用户管理")
@RequestMapping("/user")
@RestController
//@CrossOrigin(origins = "http://localhost:3001",allowCredentials="true",allowedHeaders = "*") // 支持跨域
public class UserController {

    @Autowired
    private UserSerive userSerive;

    @ApiOperation("获取全部用户信息----queryAllUser")
    @GetMapping("/queryAllUser")
    public List<User> queryAllUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie c : cookies){
                System.out.println("***********************");
                System.out.println(c.getName());
                System.out.println(c.getValue());
                System.out.println("***********************");
            }
        }
        return userSerive.queryAllUser();
    }

    @ApiOperation("根据手机号获取用户信息----queryUserByPhone")
    @GetMapping("/queryUserByPhone")
    public User queryUserByPhone(String userPhone, HttpServletRequest request, HttpServletResponse response) {
        User user = userSerive.queryUserByPhone(userPhone);
        String domain = request.getHeader("Origin");
        Cookie cookie = new Cookie("token", Integer.parseInt(Math.random()*100000 + "")+"");
        cookie.setPath("/");
        cookie.setMaxAge(60*1);
        response.addCookie(cookie);
        return user;
    }
}
