package com.example.demo.controller;


import com.example.demo.common.FormConfig;
import com.example.demo.service.FormConfigSerive;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Api(tags = "表单信息管理")
@RequestMapping("/formConfig")
@RestController
public class FormConfigController {

    @Autowired
    private FormConfigSerive formConfigSerive;

    @ApiOperation("获取全部表单信息----queryAll")
    @GetMapping("/queryAll")
    public List<FormConfig> queryAll() {
        return formConfigSerive.queryAll();
    }

    @ApiOperation("根据id字符获取表单信息----queryFormConfigByIdStr")
    @GetMapping("/queryFormConfigByIdStr")
    public List<FormConfig> queryFormConfigByIdStr(String idStr) {
        return formConfigSerive.queryFormConfigByIdStr(idStr);
    }

    @ApiOperation("根据用户手机获取表单信息----queryFormConfigByUserPhone")
    @GetMapping("/queryFormConfigByUserPhone")
    public Map<String,List<FormConfig>> queryFormConfigByUserPhone(String userPhone) {
        return formConfigSerive.queryFormConfigByUserPhone(userPhone);
    }

    @ApiOperation("新增一条数据----insertOne")
    @PostMapping("/insertOne")
    public boolean insertOne(String userPhone) {
        String idStr = String.valueOf(System.currentTimeMillis());
        return formConfigSerive.insertOne(userPhone, idStr);
    }
}
