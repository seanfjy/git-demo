package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 攀登者1
 */
public class N_31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] heights = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(heights));
    }

    private static int getResult(int[] heights) {
        int count = 0;

        for (int i = 0; i < heights.length; i++) {
            int leftHeight = i == 0 ? 0 : heights[i - 1];
            int rightHeight = i == heights.length - 1 ? 0 : heights[i + 1];

            if (heights[i]>leftHeight && heights[i]>rightHeight){
                count++;
            }
        }

        return count;
    }
}
