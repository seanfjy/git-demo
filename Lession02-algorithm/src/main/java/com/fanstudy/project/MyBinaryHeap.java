package com.fanstudy.project;

import java.util.Arrays;

/**
 * 二叉堆
 */
public class MyBinaryHeap {

    /**
     * "上浮"调整
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array){
        int childIndex = array.length-1;
        int parentIndex = (childIndex-1)/2;

        int temp = array[childIndex];

        while (childIndex>0&&temp<array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex-1)/2;
        }

        array[childIndex] = temp;
    }

    /**
     * "下沉"调整
     * @param array
     * @param parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array,int parentIndex,int length){
        int temp = array[parentIndex];
        int childIndex = 2*parentIndex +1;
        while (childIndex <length){
            //如果有右孩子,且右孩子小于左孩子,则定位的右孩子
            if (childIndex+1<length&& array[childIndex+1]<array[childIndex]){
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值,则直接跳出
            if (temp<=array[childIndex]){
                break;
            }
            array[parentIndex] =array[childIndex];
            parentIndex = childIndex;
            childIndex = 2*childIndex+1;

        }
        array[parentIndex] =temp;

    }

    /**
     * 构建堆
     * @param array 待调整的堆
     */
    public static  void buildHeap(int[] array){
        //从最后一个非叶子结点依次做"下沉"操作
        for (int i = (array.length-2)/2; i >=0; i--) {
            downAdjust(array,i,array.length);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }


}
