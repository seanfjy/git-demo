package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 8 靠谱的车
 *
 *获取每个位数的真实值,进制处理
 */
public class N_62 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(array));
    }

    private static int getResult(int[] array) {
        int truthFee = 0;
        for (int i = 0; i < array.length; i++) {
            int fault = array[i];
            if (fault > 4)
                fault--;
            for (int j = array.length - i - 1; j > 0; j--) {
                fault *= 9;
            }
            truthFee += fault;
        }

        return truthFee;
    }
}
