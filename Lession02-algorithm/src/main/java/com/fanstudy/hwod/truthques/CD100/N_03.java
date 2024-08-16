package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 最长子字符串的长度（一）
 * 逻辑分析题 -统计某字符个数
 */
public class N_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int length = str.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 'o') {
                count++;
            }
        }
        // 偶数
        if ((count & 1) == 0) {
            System.out.println(length);
        } else {
            System.out.println(length - 1);
        }
    }
}
