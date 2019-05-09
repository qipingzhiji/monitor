package com.holk.service;

import com.holk.fegin.client.FeginClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private FeginClient feginClient;

    @Override
    @HystrixCommand(fallbackMethod = "getInfoError")//ribbon使用断路器的方式
    public String getInfo(String name, String id) {
        return feginClient.showInfo(name,id);
    }

    public String getInfoError(String name,String id) {
        return "you request service is error！";
    }
}
