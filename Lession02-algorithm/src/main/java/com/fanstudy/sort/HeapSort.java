package com.fanstudy.sort;

/**
 * 堆排序
 */
public class HeapSort {

    /**
     * 下沉 调整
     * 
     * @param array 待调整的堆
     * @param parentIndex 要"下沉"的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            if (temp >= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序(升序)
     * @param array
     */
    public static void heapSort(int[] array){
        //把无序数组构建成最大准
        for (int i = (array.length-2)/2;i>=0;i--){
            downAdjust(array,i,array.length);
        }
        //循环删除堆顶元素,一刀集合尾部,调整堆产生新的堆顶
        for (int i = array.length-1;i>0;i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            downAdjust(array,0,i);
        }
    }
}
