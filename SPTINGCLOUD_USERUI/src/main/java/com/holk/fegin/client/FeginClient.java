package com.holk.fegin.client;

import com.holk.HiHystric.SchedualServiceHiHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "userservice", fallback = SchedualServiceHiHystric.class)//此注解代表开启fegin的负载均衡
public interface FeginClient {

    /**
     *  生产环境中应该注意的：
     *  1.不能使用GetMapping,PostMapping这种复合mapping,而要使用RequestMapping
     *  2.@PathVariable,@RequestParam必须要给value进行赋值
     *  3.方法里面的参数是复杂对象,尽快指定是post,但是fegin默认还是以post方法进行请求
     *  4.定义的只能是接口,且不需要实现,但是有一个要求就是这么的@RequestMapping中的value要和服务提供者里面的方法是一致的
     * @param name
     * @return
     */

    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    String showInfo(@RequestParam(value ="name") String name,@RequestParam(value = "id") String id);
}
