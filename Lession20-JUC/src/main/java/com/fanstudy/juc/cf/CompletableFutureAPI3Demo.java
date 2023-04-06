package com.fanstudy.juc.cf;

import java.util.concurrent.CompletableFuture;

/**
 * @auther zzyy
 * @create 2022-01-17 17:18
 */
public class CompletableFutureAPI3Demo {
    public static void main(String[] args) {
        /*CompletableFuture.supplyAsync(() -> 1).thenApply(f -> f + 2).thenApply(f -> f + 3)
            .thenAccept(System.out::println);*/

        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenRun(() -> {
        }).join());
        System.out
            .println(CompletableFuture.supplyAsync(() -> "resultA").thenAccept(r -> System.out.println(r)).join());
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenApply(r -> r + "resultB").join());

    }
}
