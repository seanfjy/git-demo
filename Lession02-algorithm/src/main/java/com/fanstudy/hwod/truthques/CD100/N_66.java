package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

// 整型数组按个位值排序
public class N_66 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] arr =
            Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> {
            int new_a = Math.abs(a % 10);
            int new_b = Math.abs(b % 10);
            return new_a - new_b;
        });

        StringJoiner stringJoiner = new StringJoiner(",");
        for (Integer integer : arr) {
            stringJoiner.add(String.valueOf(integer));
        }
        System.out.println(stringJoiner);
    }
}
