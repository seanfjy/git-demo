package com.fanstudy.hwod.truthques.CD100;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * CPU算力分配
 * 逻辑分析  sumA -a -b = sumB -b +a
 */
public class N_28 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int L1 = in.nextInt();
        int L2 = in.nextInt();
        int[] A = new int[L1];
        int sumA = 0;
        for (int i = 0; i < L1; i++) {
            A[i] = in.nextInt();
            sumA += A[i];
        }
        int sumB = 0;
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < L2; i++) {
            int b = in.nextInt();
            sumB += b;
            setB.add(b);
        }

        // a-b
        int half_diff = (sumA - sumB) / 2;
        int minA = Integer.MAX_VALUE;
        String ans = "";
        for (int a : A) {
            int b = a - half_diff;
            if (setB.contains(b)) {
                if (a < minA) {
                    minA = a;
                    ans = a + " " + b;
                }
            }
        }
        System.out.println(ans);

    }
}
