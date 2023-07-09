package com.fanstudy.project;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import com.fanstudy.sort.CountSort;
import com.fanstudy.sort.HeapSort;
import com.fanstudy.sort.QuickSort;

public class SortTest {

    @Test
    void testSort(){
        int num = 10000000;
        int[] base = new int[num];
        for (int i = 0; i < num; i++) {
            base[i] = ThreadLocalRandom.current().nextInt(0, num * 10);
        }
//        System.out.println(Arrays.toString(base));


        StopWatch stopWatch = new StopWatch("常用排序性能测试");

        /*int[] array = Arrays.copyOf(base, num);
        stopWatch.start("普通冒泡");
        BubbleSort.sortBase(array);
        stopWatch.stop();
        int[] array2 = Arrays.copyOf(base, num);
        stopWatch.start("冒泡优化一");
        BubbleSort.sortOne(array2);
        stopWatch.stop();
        int[] array3 = Arrays.copyOf(base, num);
        stopWatch.start("冒泡优化二");
        BubbleSort.sortTwo(array3);
        stopWatch.stop();
        int[] array4 = Arrays.copyOf(base, num);
        stopWatch.start("冒泡优化三,鸡尾酒排序");
        BubbleSort.sortTwo(array4);
        stopWatch.stop();*/
        int[] array5 = Arrays.copyOf(base, num);
        stopWatch.start("快速排序递归-双边循环法");
        QuickSort.quickSort(array5,0,array5.length-1);
        stopWatch.stop();
        int[] array6 = Arrays.copyOf(base, num);
        stopWatch.start("快速排序递归-单边循环法");
        QuickSort.quickSortOne(array6,0,array6.length-1);
        stopWatch.stop();
        int[] array7 = Arrays.copyOf(base, num);
        stopWatch.start("快速排序非递归-单边循环法");
        QuickSort.quickSortWithStack(array7,0,array7.length-1);
        stopWatch.stop();
        int[] array8 = Arrays.copyOf(base, num);
        stopWatch.start("堆排序");
        HeapSort.heapSort(array8);
        stopWatch.stop();
        int[] array9 = Arrays.copyOf(base, num);
        stopWatch.start("计数排序");
        int[] ints = CountSort.countSort(array9);
        stopWatch.stop();
//        System.out.println(Arrays.toString(ints));
        System.out.println(stopWatch.prettyPrint());
    }
}
