package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 分割均衡字符串  数量相等可分割
 */
public class N_18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int ans = 0;
        int countX = 0;
        int countY = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'X'){
                countX++;
            }else if (str.charAt(i) == 'Y'){
                countY++;
            }
            if (countX == countY){
                ans++;
            }

        }

        System.out.println(ans);
    }
}
