package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 找朋友
 */
public class N_73 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] heights = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(n, heights));
    }

    private static String getResult(int n, int[] heights) {
        // 定义新位置数组
        int[] pos = new int[n];
        // 单调栈记录index
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                pos[stack.pop()] = i;
            }
            stack.push(i);
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int po : pos) {
            sj.add(String.valueOf(po));
        }
        return sj.toString();
    }
}
