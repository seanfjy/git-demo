package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 用连续自然数之和来表达整数
 *
 * 滑动窗口
 */
public class N_64 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        getResult(in.nextInt());
    }

    private static void getResult(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        ArrayList<int[]> ans = new ArrayList<>();
        int l = 0;
        int r = 1;
        int sum = arr[l];
        while (l < n) {
            if (sum > n) {
                sum -= arr[l++];
            } else if (sum == n) {
                ans.add(Arrays.copyOfRange(arr, l, r));
                if (r >= n) {
                    break;
                }
                sum += arr[r++];
            } else {
                sum += arr[r++];
            }
        }

        ans.sort((a, b) -> a.length - b.length);
        for (int[] an : ans) {
            StringJoiner sj = new StringJoiner("+");
            for (int v : an) {
                sj.add(String.valueOf(v));
            }
            System.out.println(n + "=" + sj);
        }
        System.out.println("Result:"+ans.size());

    }
}
