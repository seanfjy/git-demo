package com.fanstudy.designmode.singleton.typeone;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);

        Runtime runtime = Runtime.getRuntime();
    }

}

class Singleton {

    // 1.构造器私有化
    private Singleton() {}

    // 2.本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    // 3.提供一个公共的静态方法,返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

}