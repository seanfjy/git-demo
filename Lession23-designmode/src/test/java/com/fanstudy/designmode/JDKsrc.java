package com.fanstudy.designmode;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.DispatcherServlet;

public class JDKsrc {

    @Test
    void testFactory(){

        Calendar cal = Calendar.getInstance();
        // 注意月份下标从0 开始，所以取月份要+1
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));
    }

    @Test
    void testbuild() {
        StringBuilder stringBuilder = new StringBuilder("hello,world");
        System.out.println(stringBuilder);
    }

    @Test
    void springmvc() {
        DispatcherServlet dispatcherServlet;
    }

    @Test
    void testdecorator() throws FileNotFoundException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(""));
    }

    @Test
    void mybatis() {

    }

    @Test
    void testflyweight() {
        Integer i = 123;
    }
}
