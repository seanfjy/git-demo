package com.fanstudy.exceptionhandler.controller;

import com.fanstudy.exceptionhandler.vo.OrderVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/order/new")
    public String createOrder(@Validated @RequestBody OrderVO orderVO){
        return "订单信息:"+orderVO.toString();
    }
}
