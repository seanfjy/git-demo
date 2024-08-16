package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 多段线数据压缩
 */
public class N_40 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(nums));
    }

    private static String getResult(int[] nums) {
        StringJoiner sj = new StringJoiner(" ");
        // 坐标
        int preX = nums[0];
        int preY = nums[1];

        // 运动方向
        int preDirectX = 0;
        int preDirectY = 0;

        for (int i = 2; i < nums.length; i += 2) {
            int curX = nums[i];
            int curY = nums[i + 1];

            int offsetX = curX - preX;
            int offsetY = curY - preY;

            int base = Math.max(Math.abs(offsetX), Math.abs(offsetY));
            int directX = offsetX / base;
            int directY = offsetY / base;

            if (directX != preDirectX || directY != preDirectY) {
                sj.add(preX + " " + preY);
            }
            preX = curX;
            preY = curY;

            preDirectX = directX;
            preDirectY = directY;

        }

        // 收尾
        sj.add(preX + " " + preY);
        return sj.toString();

    }

}
