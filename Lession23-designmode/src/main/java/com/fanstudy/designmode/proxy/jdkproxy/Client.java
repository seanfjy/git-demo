package com.fanstudy.designmode.proxy.jdkproxy;

public class Client {
    public static void main(String[] args) {
        SmsService proxy = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        proxy.send("java");
    }
}
