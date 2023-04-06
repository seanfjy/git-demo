package com.fanstudy.juc.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @auther zzyy
 * @create 2022-01-17 15:20
 */
public class CompletableFutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        // demo1();
        // demo2();
//        demo3();
         group1();
    }

    private static void demo2() {
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "----come in");
            int result = ThreadLocalRandom.current().nextInt(100);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return result;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("---计算完成,更新系统updateValue: " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("异常情况: " + e.getCause() + "\t" + e.getMessage());
            return null;
        });
        System.out.println(Thread.currentThread().getName() + "线程先去忙其它任务");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void demo3() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "----come in");
            int result = ThreadLocalRandom.current().nextInt(100);
            if (result>50){
                int i = 10/0;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return result;
        }, executorService).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("---计算完成,更新系统updateValue: " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("异常情况: " + e.getCause() + "\t" + e.getMessage());
            return null;
        });
        System.out.println(Thread.currentThread().getName() + "线程先去忙其它任务");

        executorService.shutdown();
    }

    private static void demo1() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);
        System.out.println(completableFuture.get());

        executorService.shutdown();
    }

    /**
     * 获得结果和触发计算
     * 
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private static void group1() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            // 暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });

//        System.out.println(completableFuture.get());
//        System.out.println(completableFuture.get(2L, TimeUnit.SECONDS));
//        System.out.println(completableFuture.join());

        // 暂停几秒钟线程
         try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

//         System.out.println(completableFuture.getNow("xxx"));
        System.out.println(completableFuture.complete("completeValue") + "\t" + completableFuture.join());
    }
}
