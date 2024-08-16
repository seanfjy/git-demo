package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 最富裕的小家庭
 * 逻辑分析 - 子节点值加到父节点上
 */
public class N_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] wealth = new int[n + 1];
        int[] family = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wealth[i] = in.nextInt();
            family[i] = wealth[i];
        }

        for (int i = 0; i < n - 1; i++) {
            int fa = in.nextInt();
            int ch = in.nextInt();
            family[fa] += wealth[ch];
        }
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            maxValue= Math.max(maxValue, family[i]);
        }
        System.out.println(maxValue);

    }
}
