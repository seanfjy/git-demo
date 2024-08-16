package com.fanstudy.hwod.niuke;

import java.util.Arrays;
import java.util.Scanner;

public class HJ24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = in.nextInt();
            }

            System.out.println(getMinStudentOut(height));

        }
    }

    private static int getMinStudentOut(int[] height) {
        int n = height.length;
        int[] dp_h = new int[n];
        int[] dp_l = new int[n];
        Arrays.fill(dp_h, 1);
        Arrays.fill(dp_l, 1);
        // 正序遍历
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j]) {
                    dp_h[i] = Math.max(dp_h[i], dp_h[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (height[i] > height[j]) {
                    dp_l[i] = Math.max(dp_l[i], dp_l[j] + 1);
                }
            }
        }
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            if (dp_h[i] + dp_l[i] - 1 > maxNum) {
                maxNum = dp_h[i] + dp_l[i] - 1;
            }
        }

        return n - maxNum;
    }
}
