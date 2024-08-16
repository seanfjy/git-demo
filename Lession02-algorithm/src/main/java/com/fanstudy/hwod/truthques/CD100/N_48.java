package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;
import java.util.StringJoiner;

// 字符串分割(二)
public class N_48 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        System.out.println(getResult(k, str));
    }

    private static String getResult(int k, String str) {
        String[] split = str.split("-");
        String first = split[0];
        StringJoiner sj = new StringJoiner("-");
        sj.add(first);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < split.length; i++) {
            sb.append(split[i]);
        }

        String newStr = sb.toString();

        for (int i = 0; i < newStr.length(); i += k) {
            String sub = newStr.substring(i, Math.min(i+k, newStr.length()));
            sj.add(convert(sub));
        }
        return sj.toString();
    }

    private static String convert(String str) {
        int lowerCnt = 0;
        int upperCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                lowerCnt++;
            } else if (Character.isUpperCase(c)) {
                upperCnt++;
            }

        }
        if (lowerCnt > upperCnt) {
            return str.toLowerCase();
        } else if (lowerCnt < upperCnt) {
            return str.toUpperCase();
        } else {
            return str;
        }

    }

}
