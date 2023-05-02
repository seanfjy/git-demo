package com.fanstudy.designmode.singleton.typetwo;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }

}

class Singleton {

    // 构造器私有化
    private Singleton() {}

    private static Singleton instance;

    //静态代码块初始化实例对象
    static {
        instance = new Singleton();
    }

    // 提供一个公共的静态方法,返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

}