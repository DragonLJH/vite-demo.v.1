package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserTieUpFormConfigMapper {
    @Select("select count(user_phone) from user_tie_up_form_config")
    Integer countAll();

    @Select("select user_phone,id_str from user_tie_up_form_config")
    String queryAll();

    @Select("select id_str from user_tie_up_form_config where user_phone = #{userPhone}")
    List<String> queryIdStrByUserPhone(String userPhone);

    @Insert("INSERT INTO user_tie_up_form_config (user_phone, id_str)\n" +
            "    VALUES (#{userPhone}, #{idStr}) ")
    void insertOne(String userPhone, String idStr);


}
