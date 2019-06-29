package com.xin.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jack_yang
 * @Date: 2019/6/28 20:06
 */
@RestController
public class HelloController {

    @Value("${hello}")
     private String hello;

    @GetMapping("hello")
     public String sayHello(){
         return hello;
     }
}
