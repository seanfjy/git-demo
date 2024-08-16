package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小明找位置
 *
 * 二分法
 */
public class N_17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(in.nextLine());
        System.out.println(search(arr, target));
//        int i = Arrays.binarySearch(arr, target);
//        if(i<0){
//            i = -i-1;
//        }
//        System.out.println(i+1);
    }

    private static int search(int[] arr, int target) {

        int left = 0;
        int right = arr.length-1;
        if(target<arr[left]){
            return 1;
        }
        if (target> arr[right]){
            return arr.length+1;
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }
        return left + 1;

    }
}
