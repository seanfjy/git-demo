package com.fanstudy.juc.atomics;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @auther zzyy
 * @create 2022-02-26 18:51
 */
public class LongAdderAPIDemo {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();

        longAdder.increment();
        longAdder.increment();
        longAdder.increment();

        System.out.println(longAdder.sum());

        LongAccumulator longAccumulator = new LongAccumulator((left, right) -> left + right, 0);

        longAccumulator.accumulate(1);// 1
        longAccumulator.accumulate(3);// 4

        System.out.println(longAccumulator.get());
    }
}
