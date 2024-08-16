package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

public class N_70 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String res = s.replaceAll(",", "").replaceAll("111", "x").replaceAll("11", "x").replaceAll("1", "x");

        int ans = 0;
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == 'x') {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
