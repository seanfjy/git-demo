package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

public class N_52 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().replaceFirst("/*,/*", "/");
        System.out.println(s);
    }
}
