package com.fanstudy.distributelock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fanstudy.distributelock.mapper")
public class Lession22DistributelockApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lession22DistributelockApplication.class, args);
    }

}
