package com.fanstudy.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "com.fanstudy.mybatis.mapper")
@SpringBootApplication
public class Lession10MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lession10MybatisApplication.class, args);
    }

}
