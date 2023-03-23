package com.fanstudy.pk1;

import java.lang.reflect.RecordComponent;
import java.util.Arrays;

import org.junit.Test;

public class CustomerTest {
    @Test
    public void test() {
        Address address = new Address("上海", "南京路2001", "10000");
        PhoneNumber phoneNumber = new PhoneNumber("86", "1348888888");
        Customer customer = new Customer("001", "sean", phoneNumber, address);

        Class<? extends Customer> aClass = customer.getClass();
        //判断Customer是否为Java Record类型
        boolean record = aClass.isRecord();
        System.out.println(record);

        RecordComponent[] recordComponents = aClass.getRecordComponents();
        Arrays.stream(recordComponents).forEach(System.out::println);
    }
}