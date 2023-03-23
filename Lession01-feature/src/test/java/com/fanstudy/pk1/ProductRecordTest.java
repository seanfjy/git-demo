package com.fanstudy.pk1;

import org.junit.Test;

import lombok.val;

public class ProductRecordTest {
    @Test
    public void test01() {
        ProductRecord productRecord = new ProductRecord(1001, "手机", 200);
        productRecord.print();

    }

    @Test
    public void test02() {
        // 定义local Record
        record SaleRecord(String saleId, String productName, Double money) {
        }
        // 创建对象
        SaleRecord saleRecord = new SaleRecord("S1001", "显示器", 3000.01);
        System.out.println("saleRecord =" + saleRecord);
    }

    @Test
    public void test03() {
        Address address = new Address("上海", "南京路2001", "10000");
        PhoneNumber phoneNumber = new PhoneNumber("86", "1348888888");
        Customer sean = new Customer("001", "sean", phoneNumber, address);
        System.out.println("customer = "+sean);

        String number = sean.phoneNumber().number();
        String address1 = sean.address().address();
        System.out.println("number+address ="+number + address1);
    }

    @Test
    public void test04() {
        Person lisi = new Person("lisi", 22);
        val someService = new SomeService();
        boolean eligible = someService.isEligible(lisi);
        System.out.println(eligible);
    }

    @Test
    public void test05() {
        val someService = new SomeService();
        boolean eligible = someService.isEligible(null);
        System.out.println(eligible);
    }
}