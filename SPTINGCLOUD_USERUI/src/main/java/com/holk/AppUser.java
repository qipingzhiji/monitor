package com.holk;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude=
        {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})//eureka服务器启动时,不需要加载数据库配置
@EnableEurekaClient
@EnableFeignClients
@RestController
@EnableHystrix
public class AppUser {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(AppUser.class).web(true).run(args);
    }
}
