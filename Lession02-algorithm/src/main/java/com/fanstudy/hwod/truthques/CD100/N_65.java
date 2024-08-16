package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

// 寻找身高相近的小朋友
public class N_65 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int n = in.nextInt();
        Integer[] heights = new Integer[n];
        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }
        Arrays.sort(heights, (a, b) -> {
            int abs_A = Math.abs(a - h);
            int abs_B = Math.abs(b - h);

            return abs_A != abs_B ? abs_A - abs_B : a - b;
        });
        StringJoiner sj = new StringJoiner(" ");
        for (int height : heights) {
            sj.add(String.valueOf(height));
        }
        System.out.println(sj);
    }
}
