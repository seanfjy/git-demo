package com.fanstudy.quickweb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamPathController {

    //使用?表示单个字符
    @GetMapping("/file/t?st.html")
    public String path1(HttpServletRequest request){
        return "path请求:"+request.getRequestURI();
    }
    //* 表示0个或多个字符
    @GetMapping("/images/*.gif")
    public String path2(HttpServletRequest request){
        return "path2请求:"+request.getRequestURI();
    }
    //** 表示多个路径或字符
    @GetMapping("/pig/**")
    public String path3(HttpServletRequest request){
        return "path3请求:"+request.getRequestURI();
    }

    //路径变量 {*变量名称}
    @GetMapping("/order/{*id}")
    public String path4(@PathVariable("id") String orderId,HttpServletRequest request){
        return "path4请求:"+request.getRequestURI()+" ,id="+orderId;

    }

    //正则表达式
    @GetMapping("/pages/{fname:\\w+}.log")
    public String path5(@PathVariable("fname") String fname,HttpServletRequest request){

        return "path5请求:"+request.getRequestURI()+" ,id="+fname;

    }
}
