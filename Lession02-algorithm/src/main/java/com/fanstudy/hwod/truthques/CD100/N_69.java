package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 数组连续和
 */
public class N_69 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(getResult(n, arr, target));

    }

    private static long getResult(int n, int[] arr, int target) {

        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }
        long ans = 0;

        int l = 0;
        int r = 1;

        while (r <= n) {
            if (preSum[r] - preSum[l] >= target) {
                ans += n - r + 1;
                l++;
                r = l + 1;
            } else {
                r++;
            }
        }
        return ans;

    }
}
