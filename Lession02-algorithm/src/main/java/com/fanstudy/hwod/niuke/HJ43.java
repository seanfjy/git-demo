package com.fanstudy.hwod.niuke;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ43 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] s = line.split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            map = new int[n][m];

            for (int i = 0; i < n; i++) {
                String row = in.nextLine();
                String[] val = row.split(" ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(val[j]);
                }
            }
            visited = new boolean[n][m];
            dfs(0, 0);
            StringBuilder sb = new StringBuilder();
            for (int[] ints : minPath) {
                sb.append("(").append(ints[0]).append(",").append(ints[1]).append(")\n");
            }
            System.out.print(sb);

        }
    }

    private static void dfs(int i, int j) {
        if (i > map.length - 1 || i < 0 || j > map[0].length - 1 || j < 0 || visited[i][j] || map[i][j] == 1 ||
        // 判断该路径是否最短
            (minPath != null && path.size() >= minPath.size())) {
            return;
        }
        if (i == map.length - 1 && j == map[0].length - 1) {
            path.addLast(new int[] {i, j});
            minPath = new ArrayList<>(path);
            path.removeLast();
            return;
        }
        path.addLast(new int[] {i, j});
        visited[i][j] = true;
        for (int[] direction : directions) {
            dfs(i + direction[0], j + direction[1]);
        }
        visited[i][j] = false;
        path.removeLast();

    }

    private static int[][] map;
    private static List<int[]> minPath;
    private static Deque<int[]> path = new LinkedList<>();
    private static boolean[][] visited;
    private static int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
}
