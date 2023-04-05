package com.fanstudy.juc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession20JucApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("当前线程为:"+(Thread.currentThread().isDaemon()?"守护线程"  :"用户线程"));
        }, "线程1");

        thread.start();
        Thread.sleep(3000);

        System.out.println("main线程结束了");

    }

}
