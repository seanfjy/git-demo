package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;

// 字符串筛选排序
public class N_50 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int k = Integer.parseInt(in.nextLine());
        System.out.println(getResult(k, str));
    }

    private static int getResult(int k, String str) {

        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        return str.indexOf(charArray[k > charArray.length ? charArray.length - 1 : k - 1]);

    }
}
