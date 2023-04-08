package com.fanstudy.graalvm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello/{id}")
    public String sayHello(@PathVariable("id") Integer id) {
        String str;
        switch (id) {
            case 1 -> str = "你好,陌生人";
            case 2 -> str = "你好,中国";
            case 3 -> str = "你好,法国";
            default -> str = "你好,世界";
        }
        return str;
    }
}
