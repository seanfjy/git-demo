package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 小明的幸运数
 */
public class N_26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 1 || n > 100) {
            System.out.println("12345");
            return;
        }
        int m = in.nextInt();
        if (m < -100 || m > 100) {
            System.out.println("12345");
            return;
        }

        int maxPos = 0;
        int pos = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (num < -100 || num > 100) {
                System.out.println("12345");
                return;
            }

            pos += num;
            if (num == m) {
                if (num > 0) {
                    pos += 1;
                } else if (num < 0) {
                    pos -= 1;
                }
            }
            maxPos = Math.max(maxPos, pos);

        }
        System.out.println(maxPos);
    }
}
