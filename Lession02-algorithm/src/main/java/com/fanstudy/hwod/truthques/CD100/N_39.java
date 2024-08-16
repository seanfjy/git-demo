package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 精准核酸检测
 *
 * 并查集
 */
public class N_39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] confirmed = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(getResult(n, confirmed, matrix));
    }

    private static int getResult(int n, int[] confirmed, int[][] matrix) {
        UnionFindSet ufs = new UnionFindSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (matrix[i][j] == 1) {
                    // 有过接触的人进行合并
                    ufs.union(i, j);
                }
            }
        }
        // 统计每个接触群体中的人数
        int[] cnts = new int[n];
        for (int i = 0; i < n; i++) {
            int fa = ufs.find(i);
            cnts[fa]++;
        }

        // 记录已统计过的感染群体
        HashSet<Integer> confirmed_fa = new HashSet<>();
        int ans = 0;
        for (int i : confirmed) {
            int fa = ufs.find(i);
            if (confirmed_fa.contains(fa)) {
                continue;
            }
            confirmed_fa.add(fa);
            ans += cnts[fa];
        }
        // 最终需要做核酸的人数,不包括已感染的人
        return ans - confirmed.length;

    }

}

class UnionFindSet {
    int[] fa;

    public UnionFindSet(int n) {
        this.fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    public int find(int x) {
        if (x != fa[x]) {
            this.fa[x] = this.find(this.fa[x]);
            return this.fa[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int x_fa = this.find(x);
        int y_fa = this.find(y);
        if (x_fa != y_fa) {
            this.fa[y_fa] = x_fa;
        }
    }
}
