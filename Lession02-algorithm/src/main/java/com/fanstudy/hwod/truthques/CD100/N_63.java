package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 素数之积
 */
public class N_63 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(getReuslt(in.nextInt()));
    }

    private static String getReuslt(int num) {
        if (isPrime(num)) {
            return "-1 -1";
        }
        // i 为某一因数
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                int j = num / i;

                if (isPrime(i) && isPrime(j)) {
                    return i < j ? i + " " + j : j + " " + i;
                } else {
                    break;
                }

            }
        }
        return "-1 -1";
    }

    private static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        for (int i = 5; i < Math.sqrt(num); i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
