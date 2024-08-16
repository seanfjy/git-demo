package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// 查找众数及中位数
public class N_59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(nums));
    }

    private static int getResult(int[] nums) {
        HashMap<Integer, Integer> cnts = new HashMap<>();
        for (int num : nums) {
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }

        int max = cnts.values().stream().max((a, b) -> a - b).orElse(0);

        List<Integer> list = new ArrayList<>();

        for (Integer key : cnts.keySet()) {
            if (max == cnts.get(key)) {
                list.add(key);
            }
        }
        list.sort((a, b) -> a - b);

        int size = list.size();
        if ((size & 1) == 0) {
            return (list.get(size / 2) + list.get(size / 2 - 1)) / 2;
        } else {
            return list.get(size / 2);
        }

    }
}
