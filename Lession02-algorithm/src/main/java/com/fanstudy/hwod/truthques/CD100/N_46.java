package com.fanstudy.hwod.truthques.CD100;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 求字符串中所有整数的最小和
 */
public class N_46 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(getResult(in.nextLine()));
    }

    private static String getResult(String s) {
        boolean isNegative = false;
        StringBuilder negative = new StringBuilder();

        BigInteger ans = new BigInteger("0");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (isNegative) {
                    negative.append(c);
                } else {
                    ans = ans.add(new BigInteger(String.valueOf(c)));
                }
            } else {
                if (isNegative && negative.length() > 0) {
                    ans = ans.subtract(new BigInteger(negative.toString()));
                    negative = new StringBuilder();
                }
                isNegative = c == '-';
            }

        }
        if (negative.length() > 0) {
            ans = ans.subtract(new BigInteger(negative.toString()));
        }

        return ans.toString();

    }
}
