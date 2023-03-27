package com.fanstudy.quickweb.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fanstudy.quickweb.vo.Person;
import com.fanstudy.quickweb.vo.User;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ParamerController {

    @GetMapping("/param/p2")
    public String person(Person person, String type) {
        return "接收参数,使用对象:" + person.toString() + ", " + type;
    }

    @GetMapping("/param/p3")
    public String person3(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        return "接收参数," + name + " ," + age;
    }

    // @RequestParam使用
    @GetMapping("/param/p4")
    public String p4(@RequestParam(value = "name", required = true) String name,
        @RequestParam(value = "age", required = false) Integer age) {
        return "p4,name=" + name + " ,age=" + age;
    }

    // @RequestHeader使用
    @GetMapping("/param/p5")
    public String p5(@RequestParam(value = "name", required = true) String name,
                     @RequestParam(value = "age", required = false) Integer age, @RequestHeader(value = "Accept") String accept) {
        return "p5,name=" + name + " ,age=" + age+" ,Accept="+accept;
    }

    //使用 @RequestBody 接收json数据
    //{"username":"lisi","age":23}
    @PostMapping("/param/json")
    public String p6(@RequestBody User user){

        return user.toString();
    }

    //使用Reader , InputStream 读取post请求体数据
    @PostMapping("param/josn2")
    public String p6(Reader reader){
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader br = new BufferedReader(reader)){
            var line = "";
            while ((line = br.readLine()) != null){
                stringBuilder.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    //接收数组 多个值
    @GetMapping("/param/vals")
    public String getMultiVal(Integer[] id){

        return Arrays.asList(id).toString();
    }
}
