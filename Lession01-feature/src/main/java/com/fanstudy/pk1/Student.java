package com.fanstudy.pk1;

import java.util.Optional;

public record Student(Integer id, String name, String email, Integer age) {

    // 实例方法,concat连接字符串

    public String concat() {
        return String.format("姓名是%s,年龄是%d", name, age);
    }

    // 静态方法,把email转化大写
    public static String emailToUpperCase(String email) {
        return Optional.of(email).orElse("no email").toUpperCase();
    }

    // 紧凑
    public Student {
        System.out.println("id = " + id);

        if (id < 1) {
            throw new RuntimeException("id < 1");
        }
    }
    //定制的构造方法
    public Student(Integer id,String name){
        this(id,name,null,null);
    }
}
