package com.fanstudy.juc;

import com.fanstudy.juc.volatiles.DoubleCheckSingle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession20JucApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("当前线程为:" + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
        }, "线程1");

        thread.start();
        Thread.sleep(3000);

        System.out.println("main线程结束了");

    }

    @Test
    void singleTest() {

       Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DoubleCheckSingle instance = DoubleCheckSingle.getInstance();
            System.out.println(instance);

        });

       Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DoubleCheckSingle instance = DoubleCheckSingle.getInstance();
            System.out.println(instance);

        });

       Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DoubleCheckSingle instance = DoubleCheckSingle.getInstance();
            System.out.println(instance);

        });

       t1.start();
       t2.start();
       t3.start();

    }
}
