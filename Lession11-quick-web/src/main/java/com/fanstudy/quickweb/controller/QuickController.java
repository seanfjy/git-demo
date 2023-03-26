package com.fanstudy.quickweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

/**
 * @Controller 创建控制器对象,控制器能够接收请求,响应结果
 */
@Controller
public class QuickController {

    //定义方法处理请求,方法叫做控制器方法(处理器方法)
    //Model表示模型,存储数据.这个数据最后是放在request作用域.
    //HttpServletRequest的作用域中
    @RequestMapping("/exam/quick")
    public String quick(Model model){

        //调用service处理请求,获取数据
        model.addAttribute("title","Web开发");
        model.addAttribute("time", LocalDateTime.now());
        //指定视图,显示数据
        return "quick";//它是视图文件的名称
    }


}
