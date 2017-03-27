package com.cloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/3/27.
 */
@Service
public class SomeHystrixService {

    @Autowired
    RestTemplate restTemplate; //spring boot下使用Ribbon，只需注入一个RestTemplate

    @HystrixCommand(fallbackMethod = "fallbackSome")
    public String getSome(){
        return restTemplate.getForObject("http://some/getsome",String.class);
    }

    public String fallbacksome(){
        return "some service模块故障";
    }
}
