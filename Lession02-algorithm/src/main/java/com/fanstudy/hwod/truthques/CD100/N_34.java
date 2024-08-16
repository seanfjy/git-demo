package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 来自异国的客人
 * 进制转化  % /
 */
public class N_34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();
        int n = in.nextInt();
        int m = in.nextInt();

        System.out.println(getResult(k, n, m));

    }

    private static long getResult(long k, int n, int m) {
        if (n >= m) {
            return 0;
        }
        long count = 0;

        while (k > 0) {
            long remain = k % m;
            if (remain == n){
                count++;
            }
            k/=m;
        }

        return count;
    }
}
