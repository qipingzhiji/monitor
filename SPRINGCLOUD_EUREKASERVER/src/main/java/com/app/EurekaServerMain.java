package com.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude=
        {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})//eureka服务器启动时,不需要加载数据库配置
@EnableEurekaServer
@ComponentScan
public class EurekaServerMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerMain.class).web(true).run(args);
    }
}
