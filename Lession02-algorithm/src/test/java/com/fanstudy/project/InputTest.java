package com.fanstudy.project;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class InputTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nextInt = sc.nextInt();
        int n = 0;
        for (int i = 0; i < 32; i++) {
            if ((nextInt & 1) == 1) {
                n++;
            }
            nextInt >>>= 1;
        }
        System.out.println(n);

    }

    @Test
    public void test() {
        System.out.println(8 >> 3);
    }
}
