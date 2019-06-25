package com.xin.eurekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jack_yang
 * @Date: 2019/6/25 18:57
 */
@RestController
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @GetMapping("hello")
    public String index(){
        StringBuffer buffer = new StringBuffer("hello world " + port + "端口为您服务！");
        return buffer.toString();
    }
}
