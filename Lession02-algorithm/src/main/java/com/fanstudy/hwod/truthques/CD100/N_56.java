package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;

// 字符串变换最小字符串
public class N_56 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(getResult(in.nextLine()));
    }

    private static String getResult(String s) {
        char[] minStrArr = s.toCharArray();
        Arrays.sort(minStrArr);
        String minStr = new String(minStrArr);
        if (minStr.equals(s))
            return s;
        char[] sArr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (sArr[i] != minStrArr[i]) {
                char temp = sArr[i];
                sArr[i] = minStrArr[i];
                int swapIndex = s.lastIndexOf(minStrArr[i]);
                sArr[swapIndex] = temp;
                break;
            }
        }
        return new String(sArr);

    }
}
