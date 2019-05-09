package com.holk.controller;

import com.holk.fegin.client.FeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeginController {

    @Autowired
    private FeginClient feginClient;

    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public String showInfo(@RequestParam String name, @RequestParam String id){
        return feginClient.showInfo(name,id);
    }
}
