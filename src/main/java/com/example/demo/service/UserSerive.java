package com.example.demo.service;

import com.example.demo.common.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserSerive {

    @Autowired
    public UserMapper userMapper;

    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    public User queryUserByPhone(String userPhone) {
        return userMapper.queryUserByPhone(userPhone);
    }

}
