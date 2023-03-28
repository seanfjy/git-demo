package com.fanstudy.servletfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.fanstudy.servletfilter")
@SpringBootApplication
public class Lession12ServletFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lession12ServletFilterApplication.class, args);
    }

}
