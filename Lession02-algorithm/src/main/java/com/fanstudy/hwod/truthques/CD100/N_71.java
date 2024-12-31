package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 绘图机器
 */
public class N_71 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int end_x = in.nextInt();

        int last_x = 0;
        int last_y = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int cur_x = in.nextInt();
            int offset_y = in.nextInt();
            ans += (long) (cur_x - last_x) * Math.abs(last_y);

            last_x = cur_x;
            last_y += offset_y;

        }

        if (end_x > last_x) {
            ans += (long) (end_x - last_x) * Math.abs(last_y);
        }
        System.out.println(ans);
    }
}
