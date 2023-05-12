package com.example.demo.mapper;

import com.example.demo.common.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select user_id, user_phone, user_password, user_name, user_power from user")
    List<User> queryAllUser();

    @Select("select user_id, user_phone, user_password, user_name, user_power from user where user_phone = #{userPhone}")
    User queryUserByPhone(String userPhone);
}
