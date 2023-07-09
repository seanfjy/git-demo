package com.fanstudy.sort;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 普通
     * 
     * @param array
     */
    public static void sortBase(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化一
     * 
     * @param array
     */
    public static void sortOne(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {

            // 有序标记,每一轮初始值为true
            boolean isSorted = true;

            for (int j = 0; j < array.length - i - 1; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 优化二
     * 
     * @param array
     */
    public static void sortTwo(int[] array) {
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数列的边界,每次比较只需要比到这里为止
        int sortBorder = array.length - 1;

        for (int i = 0; i < array.length - 1; i++) {

            // 有序标记,每一轮初始值为true
            boolean isSorted = true;

            for (int j = 0; j < sortBorder; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 优化三 -鸡尾酒排序
     *
     * @param array
     */
    public static void sortThree(int[] array) {
        int temp = 0;

        for (int i = 0; i < array.length / 2; i++) {

            // 有序标记,每一轮初始值为true
            boolean isSorted = true;

            // 奇数轮,从左向右比较和交换
            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            // 偶数轮,将isSorted 重新标记true
            isSorted = true;
            for (int j = array.length - i - 1; j > i; j--) {

                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;

                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int num = 100000;
        int[] base = new int[num];
        for (int i = 0; i < num; i++) {
            base[i] = ThreadLocalRandom.current().nextInt(0, num * 10);
        }
//        System.out.println(Arrays.toString(base));


        StopWatch stopWatch = new StopWatch("性能测试");

        int[] array = Arrays.copyOf(base, num);
        stopWatch.start("普通冒泡");
        sortBase(array);
        stopWatch.stop();
        int[] array2 = Arrays.copyOf(base, num);
        stopWatch.start("冒泡优化一");
        sortOne(array2);
        stopWatch.stop();
        int[] array3 = Arrays.copyOf(base, num);
        stopWatch.start("冒泡优化二");
        sortTwo(array3);
        stopWatch.stop();
        int[] array4 = Arrays.copyOf(base, num);
        stopWatch.start("冒泡优化三,鸡尾酒排序");
        sortTwo(array4);
        stopWatch.stop();
//        System.out.println(Arrays.toString(array4));
        System.out.println(stopWatch.prettyPrint());
    }
}
