package com.fanstudy.designmode.singleton.typesix;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {

            CompletableFuture.runAsync(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Singleton instance = Singleton.getInstance();
                System.out.println(instance);
            });
        }

        TimeUnit.MILLISECONDS.sleep(100);
    }

}

class Singleton {

    // 构造器私有化
    private Singleton() {}

    // 静态内部类
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 提供一个公共的静态方法,当用到该方法时,才创建instance

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

}