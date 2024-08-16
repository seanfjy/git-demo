package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 游戏分组/篮球比赛
 *
 *dfs ,剪裁 获取所有组合之和  实力差: Math.abs(sum - 2*subSum). min
 */
public class N_14 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(getResult(arr));
    }

    private static int getResult(int[] arr) {
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        // dfs 求10选5的去重组合,并将组合之和记录到res中
        dfs(arr, 0, 0, 0, res);
        int sum = Arrays.stream(arr).reduce(Integer::sum).orElse(0);
        return res.stream().map(subSum -> Math.abs(sum - 2 * subSum)).min((a, b) -> a - b).orElse(0);
    }

    private static void dfs(int[] arr, int index, int deepth, int sum, List<Integer> res) {
        if (deepth == 5) {
            res.add(sum);
            return;
        }
        for (int i = index; i < 10; i++) {
            // arr 升序,进行树层去重
            if (i > index && arr[i] == arr[i - 1])
                continue;
            dfs(arr, i + 1, deepth + 1, sum + arr[i], res);
        }
    }
}
