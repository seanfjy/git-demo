package com.fanstudy.designmode.proxy.cglibproxy;

public class AliSmsService {
    public String send(String msg){
        System.out.println("send message:"+msg);
        return msg;
    }
}
