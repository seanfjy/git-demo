package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 数的分解,等差思想
 */
public class N_20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(sulution(n));
    }

    private static String sulution(long n) {
        // m至少为2
        long m = 2;

        while (true) {
            // 初始序列和  (首项+末项)*项数/2
            long Sn = (1 + m) * m / 2;

            if (Sn > n) {
                break;
            }
            // 不能整除,m加一
            if ((n - Sn) % m != 0) {
                m++;
                continue;
            }
            // 首项
            long a1 = (n - Sn) / m + 1;

            StringJoiner sj = new StringJoiner("+", n + "=", "");
            for (int i = 0; i < m; i++) {
                sj.add(String.valueOf(a1 + i));
            }
            return sj.toString();
        }
        return "N";
    }
}
