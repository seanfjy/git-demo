package com.fanstudy.designmode.singleton.type7;

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
                Singleton instance = Singleton.INSTANCE;
                System.out.println(instance.hashCode());
                instance.sayOk();
            });
        }

        TimeUnit.MILLISECONDS.sleep(100);
    }

}
enum Singleton {
    INSTANCE;
    public void sayOk(){
        System.out.println("ok~");
    }
}