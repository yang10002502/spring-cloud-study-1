package com.xin.feignclient.controller;

import com.xin.feignclient.interfaces.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Jack_yang
 * @Date: 2019/6/27 16:15
 */
@RestController
public class ConsumerController {
    @Resource
    private HelloService helloService;

    @GetMapping("feign-consumer")
    public String helloConsumer(){
        return helloService.hello();
    }
}
