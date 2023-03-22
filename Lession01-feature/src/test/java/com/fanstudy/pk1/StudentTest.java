package com.fanstudy.pk1;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void test01() {
        // 创建Record对象
        Student lisi = new Student(1001, "lisi", "lisi@qq.com", 20);
        System.out.println("lisi="+ lisi);
        //public方法器,获取属性值,只读,没有set,get方法
        Integer id = lisi.id();
        String name = lisi.name();
        System.out.println("id="+id);
        System.out.println("name="+name);

        Student zhangsan = new Student(1002, "zhangsan", "zhangsan@qq.com", 26);
        System.out.println("lisi.equals(zhangsan) ="+lisi.equals(zhangsan));
    }

    @Test
    public void test02() {
        Student lisi = new Student(1001, "lisi", "lisi@qq.com", 20);

        //用对象调用实例方法
        String concat = lisi.concat();
        System.out.println("str="+concat);
    }

    @Test
    public void test03() {
        String emailToUpperCase = Student.emailToUpperCase("lisi@qq.com");
        System.out.println("email ="+emailToUpperCase);
    }

    @Test
    public void test04() {
        Student student = new Student(-1,"lisi");
        System.out.println("student = "+student);
    }
}