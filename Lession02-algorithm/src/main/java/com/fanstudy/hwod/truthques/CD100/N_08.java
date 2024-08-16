package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 转盘寿司
 * 单调栈  两轮遍历
 */
public class N_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] prices = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = prices.length;
        int[] ans = Arrays.copyOf(prices, n);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * n; i++) {
            // 重置索引,防止越界
            int index = i % n;
            while (!stack.isEmpty() && prices[index] < prices[stack.peek()]) {
                ans[stack.pop()] += prices[index];
            }
            // 只有第一轮才push
            if (i < n) {
                stack.push(i);
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int price : ans) {
            sj.add(String.valueOf(price));
        }
        System.out.println(sj);
    }
}
