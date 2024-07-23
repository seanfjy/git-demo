package com.fanstudy.project.javase.thread;

import java.util.concurrent.TimeUnit;

public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
    }

}

class Cat extends Thread {
    private int count = 0;

    @Override
    public void run() {
        do {
            System.out.println("喵喵,我是喵咪" + (++count) + "线程名=" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (count != 10);
        System.out.println("线程结束....");
    }
}
