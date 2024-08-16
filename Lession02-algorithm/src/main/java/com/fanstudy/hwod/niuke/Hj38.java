package com.fanstudy.hwod.niuke;

import java.util.Scanner;

public class Hj38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int height = in.nextInt();
        System.out.println(height*(3-Math.pow(0.5,3)));
        System.out.println(height*Math.pow(0.5,5));
    }
}
