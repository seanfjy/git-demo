package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 机器人仓库搬砖
 *
 * 二分法
 */
public class N_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] bricks = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(bricks));

    }

    private static int getResult(int[] bricks) {
        int n = bricks.length;
        if (n > 8) {
            return -1;
        }
        int max = Arrays.stream(bricks).max().orElse(0);
        if (n == 8) {
           return max;
        }
        int ans = max;
        int min = 1;
        // 有等号
        while (min <= max) {
            int mid = (min + max) >> 1;
            if (check(mid, 8, bricks)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    private static boolean check(int energy, int limit, int[] bricks) {
        int cost = 0;
        for (int brick : bricks) {
            // 向上取整
            cost += (int)Math.ceil(brick * 1.0 / energy);
            if (cost > limit) {
                return false;
            }
        }
        return true;
    }
}
