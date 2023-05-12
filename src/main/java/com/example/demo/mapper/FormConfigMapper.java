package com.example.demo.mapper;

import com.example.demo.common.FormConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FormConfigMapper {

    @Select("select id, id_str, label, type, name, value from form_config")
    List<FormConfig> queryAll();

    @Select("select id, label, type, name, value from form_config where id_str = #{idStr}")
    List<FormConfig> queryFormConfigByIdStr(String idStr);
}
