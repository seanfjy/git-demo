package com.fanstudy.juc.exer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // task();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long start = System.currentTimeMillis();
        FutureTask<String> task1 = new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return "task1";
        });

        executorService.submit(task1);
        FutureTask<String> task2 = new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(400);
            return "task2";
        });
        executorService.submit(task2);

        String s = task1.get();
        System.out.println(s);

        executorService.shutdown();
        TimeUnit.MILLISECONDS.sleep(300);

        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "毫秒");

    }

    private static void task() throws InterruptedException {
        long start = System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep(500);
        TimeUnit.MILLISECONDS.sleep(400);
        TimeUnit.MILLISECONDS.sleep(300);
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "毫秒");


    }
}
