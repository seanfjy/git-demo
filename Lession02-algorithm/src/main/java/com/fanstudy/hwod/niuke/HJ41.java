package com.fanstudy.hwod.niuke;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 种类
        int n = in.nextInt();
        // 重量
        int[] w = new int[n];
        // 数量
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < n; i++) {
            int wi = w[i];
            int ci = c[i];
            for (int j = 1; j <= ci; j++) {
                Set<Integer> tempSet = new HashSet<>(set);
                for (Integer integer : tempSet) {
                    set.add(wi + integer);
                }
            }
        }
        System.out.println(set.size());

    }
}
