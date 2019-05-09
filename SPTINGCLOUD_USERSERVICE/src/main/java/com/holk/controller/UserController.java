package com.holk.controller;

import com.holk.entity.Comm;
import com.holk.entity.Result;
import com.holk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class UserController {

    @Value("${server.port}")
    String port;

    @Resource
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

    @GetMapping("/getInfo")
    public String getServerPort(@RequestParam String name, final String id){
        List<Map> paramList = userMapper.queryUserById(id);

        paramList.stream().forEach(m-> {
            System.out.println(m.get("id") + "..." + m.get("store"));
        });

        System.out.println(name+",this from server port is:"+port);
        return name+",this from server port is:"+port;
    }
}
