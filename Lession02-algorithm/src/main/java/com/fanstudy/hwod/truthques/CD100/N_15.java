package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 围棋的气
 * 逻辑分析 -判断空白处是否为黑或白的气  设置偏移量
 */
public class N_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] black = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] white = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] board = new int[19][19];
        for (int i = 0; i < black.length; i += 2) {
            int x = black[i];
            int y = black[i + 1];
            board[x][y] = 1;// 1表示黑棋
        }
        for (int i = 0; i < white.length; i += 2) {
            int x = white[i];
            int y = white[i + 1];
            board[x][y] = 2;// 2表示白棋
        }

        // 黑棋的气
        int black_air_count = 0;
        // 白棋的气
        int white_air_count = 0;

        // 方向偏移量
        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 0) {
                    boolean blackAir = false;
                    boolean whiteAir = false;

                    for (int[] offset : offsets) {
                        int newI = i + offset[0];
                        int newJ = j + offset[1];
                        if (newI < 0 || newI >= 19 || newJ < 0 || newJ >= 19) {
                            continue;
                        }
                        blackAir = blackAir || (board[newI][newJ] == 1);
                        whiteAir = whiteAir || (board[newI][newJ] == 2);

                    }
                    if (blackAir)
                        black_air_count++;
                    if (whiteAir)
                        white_air_count++;

                }
            }

        }
        System.out.println(black_air_count + " " + white_air_count);
    }
}
