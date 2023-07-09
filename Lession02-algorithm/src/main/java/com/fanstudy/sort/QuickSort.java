package com.fanstudy.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序
 */
public class QuickSort {

    public static void quickSort(int[] arr,int startIndex,int endIndex){
        if (startIndex>=endIndex){
            return;
        }
        //得到基准元素的位置
        int pivotIndex = partition(arr,startIndex,endIndex);
        //根据基准元素,分成两部分进行递归排序
        quickSort(arr,startIndex,pivotIndex-1);

        quickSort(arr,pivotIndex+1,endIndex);
    }

    public static void quickSortOne(int[] arr,int startIndex,int endIndex){
        if (startIndex>=endIndex){
            return;
        }
        //得到基准元素的位置
        int pivotIndex = partitionOne(arr,startIndex,endIndex);
        //根据基准元素,分成两部分进行递归排序
        quickSort(arr,startIndex,pivotIndex-1);

        quickSort(arr,pivotIndex+1,endIndex);
    }

    /**
     * 基于栈实现 快排
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSortWithStack(int[] arr,int startIndex,int endIndex){
        // 用一个集合栈来代替递归函数栈
        Stack<Map<String,Integer>> quickSortStack = new Stack<>();
        //整个数列的起止下标,以哈希的形式入栈
        Map<String,Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex",startIndex);
        rootParam.put("endIndex",endIndex);
        quickSortStack.push(rootParam);

        //循环结束,栈为空时
        while (!quickSortStack.isEmpty()){
            //栈顶元素出栈,得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            //得到基准元素位置
            int pivotIndex = partitionOne(arr, param.get("startIndex"), param.get("endIndex"));
            //根据基准元素分成两部分,把每一部分的起止下标入栈
            if (param.get("startIndex")<pivotIndex-1){
                Map<String,Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex",param.get("startIndex"));
                leftParam.put("endIndex",pivotIndex-1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex+1<param.get("endIndex")){
                Map<String,Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex",pivotIndex+1);
                rightParam.put("endIndex",param.get("endIndex"));
                quickSortStack.push(rightParam);
            }

        }


    }

    /**
     * 单边循环法
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partitionOne(int[] arr, int startIndex, int endIndex) {
        //取第1个位置(也可选择随机位置)的元素作为基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i=startIndex;i<=endIndex;i++){
            if (arr[i]<pivot){
                mark++;
                int p = arr[mark];
                arr[mark]=arr[i];
                arr[i]=p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    /**
     * 分治 (双边循环法)
     * @param arr 待交换的数组
     * @param startIndex 起始下标
     * @param endIndex 结束下标
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            while (left<right&&arr[right]>pivot){
                right--;
            }
            while (left<right&&arr[left]<=pivot){
                left++;
            }
            if (left<right){
                int p = arr[left];
                arr[left] = arr[right];
                arr[right]= p;
            }
        }

        //pivot和指针重合点交换
        arr[startIndex] =arr[left];
        arr[left] = pivot;

        return left;
    }
}
