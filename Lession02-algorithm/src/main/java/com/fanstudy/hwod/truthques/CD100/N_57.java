package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 查找接口成功率最优时间段 动态规划+前缀和
 */
public class N_57 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int minAverageLost = Integer.parseInt(in.nextLine());
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(nums, minAverageLost));
    }

    private static String getResult(int[] nums, int minAverageLost) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        ArrayList<int[]> ans = new ArrayList<>();

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // 区间[i,j-1] 的和
                int sum = preSum[j] - preSum[i];
                int len = j - i;
                int lost = len * minAverageLost;

                if (sum <= lost) {
                    if (len >= maxLen) {
                        if (len > maxLen) {
                            ans = new ArrayList<>();
                        }
                        ans.add(new int[] {i, j - 1});
                        maxLen = len;
                    }

                }

            }
        }
        if (ans.size() == 0)
            return "NULL";
        ans.sort((a, b) -> a[0] - b[0]);
        StringJoiner sj = new StringJoiner(" ");
        for (int[] an : ans) {
            sj.add(an[0] + "-" + an[1]);
        }
        return sj.toString();

    }
    }
