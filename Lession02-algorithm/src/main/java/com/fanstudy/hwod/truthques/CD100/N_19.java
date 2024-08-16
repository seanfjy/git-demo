package com.fanstudy.hwod.truthques.CD100;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 小华最多能得到多少克黄金、小华地图寻宝
 * dfs/bfs
 * 二维转转一维  pos= x*n+y   一维转二维x = pos/n  y= pos%n
 */
public class N_19 {

    static int m, n, k;
    static int ans = 0;
    // 二维坐标转一维
    static Set<Integer> visited = new HashSet<>();
    static int[][] visited_Two;
    static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[] digitSums;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        k = in.nextInt();
        // visited_Two = new int[m][n];
        digitSum(Math.max(m, n));

        dfs(0, 0);

        System.out.println(ans);

    }

    private static void dfs(int x, int y) {

        if (x < 0 || x >= m || y < 0 || y >= n || visited.contains(x * n + y)
        // visited_Two[x][y] == 1
            || (digitSums[x] + digitSums[y]) > k) {
            return;
        }
        visited.add(x * n + y);
        // visited_Two[x][y] = 1;
        ans++;
        for (int[] offset : offsets) {
            int newX = x + offset[0];
            int newY = y + offset[1];
            dfs(newX, newY);
        }

    }

    private static void digitSum(int maxSize) {
        digitSums = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            int num = i;
            while (num > 0) {
                digitSums[i] += num % 10;
                num /= 10;
            }

        }
    }
}
