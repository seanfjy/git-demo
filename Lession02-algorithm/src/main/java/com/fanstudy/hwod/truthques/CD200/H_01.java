package com.fanstudy.hwod.truthques.CD200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 爱吃蟠桃的孙悟空
 *
 * 二分法
 */
public class H_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] peaches = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = Integer.parseInt(in.nextLine());
        System.out.println(getResult(h, peaches));
    }

    private static int getResult(int h, int[] peaches) {
        // 桃子树棵树
        int n = peaches.length;
        if (h < n) {
            return 0;
        }
        int max = Arrays.stream(peaches).max().orElse(0);
        if (h == n) {
            return max;
        }

        int k = max;
        int min = 1;
        while (min <= max) {
            int mid = (min + max) >> 1;
            if (canEatAll(peaches, h, mid)) {
                k = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return k;

    }

    private static boolean canEatAll(int[] peaches, int h, int mid) {
        int cost = 0;
        for (int peach : peaches) {
            int hours = (int)Math.ceil(peach * 1.0 / mid);
            cost += hours;
            if (cost > h) {
                return false;
            }
        }
        return true;
    }
}
