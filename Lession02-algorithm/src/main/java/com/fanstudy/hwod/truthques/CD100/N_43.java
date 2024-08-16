package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 灰度图存储
 */
public class N_43 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] pos = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = nums[0];
        int cols = nums[1];
        int[] graph = new int[rows * cols];

        int start = 0;
        for (int i = 2; i < nums.length; i += 2) {
            int gray = nums[i];
            int len = nums[i + 1];
            // 数组填充
            Arrays.fill(graph, start, start + len, gray);
            start += len;

        }

        int target = pos[0] * cols + pos[1];
        System.out.println(graph[target]);
    }
}
