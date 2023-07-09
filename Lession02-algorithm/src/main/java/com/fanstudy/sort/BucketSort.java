package com.fanstudy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 */
public class BucketSort {

    public static double[] bucketSort(double[] array){
        // 得到数列的最大值和最小值,并算出差值d
        double max = array[0];
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max <array[i]){
                max= array[i];
            }
            if (min >array[i]){
                min = array[i];
            }
        }
        double d = max - min ;
        // 初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        //遍历原始数组,将每个元素放入桶中
        for (double v : array) {
            int num = (int) ((v - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(v);
        }
        //对每个桶内部进行排序
        for (LinkedList<Double> doubles : bucketList) {
            // JDK 底层采用了归并排序
            Collections.sort(doubles);
        }
        //输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (Double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.132,8.122,4,12,10.09};
        double[] doubles = bucketSort(array);
        System.out.println(Arrays.toString(doubles));
    }
}
