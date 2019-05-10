package com.api;

import com.api.filter.TokenFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude=
        {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableZuulProxy
public class GatewayService {
    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayService.class).web(true).run(args);
    }

    //将过滤器交给Spring管理
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    //zuul自定义添加路由规则
    /*@Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper("","");
    }*/
}
