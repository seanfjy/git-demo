package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 最多购买宝石数目
 * 双指针
 */
public class N_25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] gems = new int[n];
        for (int i = 0; i < n; i++) {
            gems[i] = in.nextInt();
        }
        int money = in.nextInt();

        int ans = 0;
        int left = 0, right = 0;
        int windowSum = 0;
        while (right < n) {
            if (windowSum + gems[right] <= money) {
                windowSum += gems[right++];
            } else {
                ans = Math.max(ans, right - left);
                windowSum -= gems[left++];
            }
        }
        if (windowSum<= money) {
            ans = Math.max(ans, right - left);
        }
        System.out.println(ans);
    }
}
