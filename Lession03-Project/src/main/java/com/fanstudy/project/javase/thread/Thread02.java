package com.fanstudy.project.javase.thread;

import java.util.concurrent.TimeUnit;

public class Thread02 {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Thread thread = new Thread(tiger);
        thread.start();

    }
}

class Tiger implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("嗷嗷, 我是小老虎" + ++count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("线程结束...");
    }
}
