package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 分披萨
 * 递归,记忆化缓存
 */
public class N_29 {

    // 披萨
    static int[] pizza;

    // 缓存结果
    static long[][] cache;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        pizza = new int[n];
        for (int i = 0; i < n; i++) {
            pizza[i] = in.nextInt();
        }
        cache = new long[n][n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            // 从某一位置开始拿披萨
            ans = Math.max(ans, recursive(check(i - 1), check(i + 1)) + pizza[i]);
        }
        System.out.println(ans);
    }

    // 从左边或右边拿取披萨的最大值
    private static long recursive(int l, int r) {
        if (pizza[l] > pizza[r]) {
            l = check(l - 1);
        } else {
            r = check(r + 1);
        }

        if (cache[l][r] > 0) {
            return cache[l][r];
        }
        if (l == r) {
            cache[l][r] = pizza[l];
        } else {
            cache[l][r] = Math.max(recursive(check(l - 1), r) + pizza[l], recursive(l, check(r + 1)) + pizza[r]);
        }
        return cache[l][r];
    }

    // 圆盘,下标重置
    private static int check(int idx) {
        if (idx < 0) {
            idx = pizza.length - 1;
        } else if (idx >= pizza.length) {
            idx = 0;
        }
        return idx;
    }
}
