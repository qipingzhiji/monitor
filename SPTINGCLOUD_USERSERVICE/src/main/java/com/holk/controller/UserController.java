package com.holk.controller;

import com.holk.entity.Comm;
import com.holk.entity.Result;
import com.holk.mapper.UserMapper;
import com.holk.service.UserService;
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

    @Autowired
    private UserService userService;

    @PostMapping(value="/validateUser")
    public Result validateUser(@RequestBody Comm comm){
        return userService.validateUser(comm);
    }

    @GetMapping("/getInfo")
    public String getServerPort(@RequestParam String name, @RequestParam String id){
        return userService.getServerPort(name, id, port);
    }
}
