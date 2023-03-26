package com.fanstudy.quickweb.controller;

import com.fanstudy.quickweb.vo.User;
import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class JsonVOController {

    //显示json视图,包含json数据
    @RequestMapping("/exam/json")
    public void responseJson(HttpServletResponse response) throws IOException {
        String json = "{\"name\":\"李四\",\"age\":20}";
        //应答 ,通过HttpServletResponse输出
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }

    //SpringMVC支持控制器方法返回对象,有框架将对象使用jackson转为json,并输出
//    @RequestMapping("/exam/json2")
    @GetMapping("/exam/json2")
    @ResponseBody
    public User getUserJson(){
        var user = new User();
        user.setName("张昂dd");
        user.setAge(32);
        return user;
    }
}
