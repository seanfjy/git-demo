package com.fanstudy.pk.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @Autowired
    private Date date;

    @Value("${spring.application.name}")
    private String appName;
    @GetMapping("/sayHello")
    public String sayHello(){
        return "====欢迎使用SpringBoot3====="+date+"===="+appName;
    }
}
