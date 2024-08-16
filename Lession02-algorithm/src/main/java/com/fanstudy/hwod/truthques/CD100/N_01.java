package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 螺旋数字矩阵
 * 逻辑分析- 模拟运动轨迹  最少列数为向上取整
 */
public class N_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int row = in.nextInt();
        // 最少列数
        int col = (int)Math.ceil(num * 1.0 / row);
        int[][] matrix = new int[row][col];
        int step = 1;
        // 要填入值的位置
        int x = 0, y = 0;
        while (step <= num) {
            while (y < col && matrix[x][y] == 0 && step <= num) {
                matrix[x][y++] = step++;
            }
            --y;
            ++x;
            while (x < row && matrix[x][y] == 0 && step <= num) {
                matrix[x++][y] = step++;
            }
            --x;
            --y;
            while (y >= 0 && matrix[x][y] == 0 && step <= num) {
                matrix[x][y--] = step++;
            }
            ++y;
            --x;
            while (x >= 0 && matrix[x][y] == 0 && step <=num) {
                matrix[x--][y] = step++;
            }
            ++x;
            ++y;

        }

        for (int i = 0; i < row; i++) {
            StringJoiner rowStr = new StringJoiner(" ");
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowStr.add("*");
                } else {
                    rowStr.add(String.valueOf(matrix[i][j]));

                }
            }
            System.out.println(rowStr);
        }

    }
}
