package com.fanstudy.designmode.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPrototype {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Object id01 = applicationContext.getBean("id01");
        System.out.println("id01 = " + id01);
    }
}
