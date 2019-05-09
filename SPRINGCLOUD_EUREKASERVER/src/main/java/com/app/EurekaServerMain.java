package com.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan
public class EurekaServerMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerMain.class).web(true).run(args);
    }
}
