package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 最大N个数与最小N个数的和
 */
public class N_60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = in.nextInt();
        }
        int n = in.nextInt();

        System.out.println(getResult(n, nums));

    }

    private static int getResult(int n, int[] nums) {
        if (n < 0) {
            return -1;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num < 0 || num > 1000) {
                return -1;
            }
            set.add(num);
        }
        Integer[] array = set.toArray(new Integer[0]);

        Arrays.sort(array, (a, b) -> a - b);

        if (array.length < 2 * n) {
            return -1;
        }
        int ans = 0;
        int l = 0, r = array.length - 1;
        while (n > 0) {
            ans += array[l++] + array[r--];
            n--;
        }

        return ans;

    }
}
