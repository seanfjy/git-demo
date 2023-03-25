package com.fanstudy.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Lession08AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lession08AopApplication.class, args);
    }

}
