package com.holk.controller;

import com.holk.fegin.client.FeginClient;
import com.holk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeginController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public String showInfo(@RequestParam String name, @RequestParam String id){
        return userService.getInfo(name,id);
    }
}
