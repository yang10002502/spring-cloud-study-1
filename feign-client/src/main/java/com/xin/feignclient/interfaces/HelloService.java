package com.xin.feignclient.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Jack_yang
 * @Date: 2019/6/27 16:14
 */
@FeignClient(value = "eureka-client")
public interface HelloService {
    @RequestMapping("/hello")
    String hello();
}
