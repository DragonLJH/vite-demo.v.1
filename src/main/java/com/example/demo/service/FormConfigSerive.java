package com.example.demo.service;

import com.example.demo.common.FormConfig;
import com.example.demo.common.User;
import com.example.demo.mapper.FormConfigMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserTieUpFormConfigMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FormConfigSerive {

    @Autowired
    public FormConfigMapper formConfigMapper;
    @Autowired
    public UserTieUpFormConfigMapper userTieUpFormConfigMapper;

    public List<FormConfig> queryAll() {
        return formConfigMapper.queryAll();
    }

    public List<FormConfig> queryFormConfigByIdStr(String idStr) {
        return formConfigMapper.queryFormConfigByIdStr(idStr);
    }

    public Map<String,List<FormConfig>> queryFormConfigByUserPhone(String userPhone) {
        List<String> idStrList = userTieUpFormConfigMapper.queryIdStrByUserPhone(userPhone);
        Map map = new HashMap<String,List<FormConfig>>();
        for(String idStr : idStrList){
            List<FormConfig> item = queryFormConfigByIdStr(idStr);
            map.put(idStr,item);
        }
        return map;
    }

    public boolean insertOne(String userPhone, String idStr) {
        int first = userTieUpFormConfigMapper.countAll();
        userTieUpFormConfigMapper.insertOne(userPhone, idStr);
        int end = userTieUpFormConfigMapper.countAll();
        return first < end;
    }
}
