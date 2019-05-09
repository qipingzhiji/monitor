package com.holk.HiHystric;

import com.holk.fegin.client.FeginClient;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements FeginClient{

    @Override
    public String showInfo(String name, String id) {
        return "your request web is error";
    }
}
