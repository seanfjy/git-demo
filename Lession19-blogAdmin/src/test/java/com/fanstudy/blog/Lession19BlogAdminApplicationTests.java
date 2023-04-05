package com.fanstudy.blog;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession19BlogAdminApplicationTests {

    private String string;

    @Test
    void contextLoads() throws ClassNotFoundException {
        String str = "hello";


        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        Class<?> aClass = Class.forName("com.fanstudy.blog.Lession19BlogAdminApplicationTests");
        for (Integer integer : integerList) {
            
        }
        System.out.println("str = " + str);
        System.out.println();
        System.out.println("integerList = " + integerList);
        System.out.println("Lession19BlogAdminApplicationTests.contextLoads");
        System.out.println("\"hi\" = " + "hi");
        System.out.println("new Date() = " + new Date());

        System.out.println("aClass = " + aClass);

    }

}
