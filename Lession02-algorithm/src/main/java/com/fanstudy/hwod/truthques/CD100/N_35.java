package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 求幸存数之和
 */
public class N_35 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int jump = Integer.parseInt(in.nextLine());
        int left = Integer.parseInt(in.nextLine());
        System.out.println(sumOfLeft(nums, jump, left));
    }

    private static int sumOfLeft(int[] nums, int jump, int left) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int start = 1;
        while (list.size() > left) {
            start += jump;
            start %= list.size();
            list.remove(start);
        }
        return list.stream().reduce(Integer::sum).orElse(0);
    }
}
