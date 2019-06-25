package com.xin.ribbonconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: Jack_yang
 * @Date: 2019/6/25 18:53
 */
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("ribbon-consumer")
    public String hello(){
        return restTemplate.getForEntity("http://eureka-client/hello",String.class).getBody();
    }
}
