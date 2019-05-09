package com.holk.service;

import com.holk.entity.Comm;
import com.holk.entity.Result;
import com.holk.mapper.UserMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result validateUser(Comm comm) {
        List<Map> maps = userMapper.queryUser(comm.getId(), comm.getStore());
        Result  r=new Result();
        if(maps.size()>0){
            r.setCode(1);
            r.setMsg("请输入正确的数值");
        }
        return r;
    }

    @Override
    public String getServerPort(String name, String id, String port) {
        List<Map> paramList = userMapper.queryUserById(id);

//        paramList.stream().forEach(m-> {
//            System.out.println(m.get("id") + "..." + m.get("store"));
//        });

        System.out.println(name+",this from server port is:"+port);
        return name+",this from server port is:"+port;
    }
}
