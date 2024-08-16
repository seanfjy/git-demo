package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 密码解密
 */
public class N_33 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for (int i = 26; i >= 1; i--) {
            String key = i + (i > 9 ? "\\*" : "");
            String val = String.valueOf((char)('a' + i - 1));
            s = s.replaceAll(key, val);
        }
        System.out.println(s);
    }
}
