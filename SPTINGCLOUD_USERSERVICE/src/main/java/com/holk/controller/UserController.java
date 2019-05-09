package com.holk.controller;

import com.holk.entity.Comm;
import com.holk.entity.Result;
import com.holk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @PostMapping(value="/validateUser")
    public Result validateUser(@RequestBody Comm comm){
        List<Map> maps = userMapper.queryUser(comm.getId(), comm.getStore());
        Result  r=new Result();
        if(maps.size()>0){
            r.setCode(1);
            r.setMsg("请输入正确的数值");
        }
        return r;
    }
}
