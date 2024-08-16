package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 找座位  判断当前空位左右情况
 *
 */
public class N_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String row = in.nextLine();
        char[] charArray = row.toCharArray();
        System.out.println(getFillNum(charArray));
    }

    private static int getFillNum(char[] rows) {
        int ans = 0;

        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == '0') {
                boolean leftEmpty = i == 0 || rows[i - 1] == '0';
                boolean rightEmpty = i == rows.length - 1 || rows[i + 1] == '0';

                if (leftEmpty&& rightEmpty){
                    rows[i] = '1';
                    ans++;
                    i++;
                }
            }
        }

        return ans;

    }
}
