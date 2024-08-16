package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 8 会议室占用时间
 * 合并区间
 */
public class N_36 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] roomTimes = new int[n][2];
        for (int i = 0; i < n; i++) {
            roomTimes[i][0] = in.nextInt();
            roomTimes[i][1] = in.nextInt();
        }
        int[][] res = merge(roomTimes);
        for (int[] time : res) {
            System.out.println(time[0] + " " + time[1]);
        }

    }

    private static int[][] merge(int[][] roomTimes) {
        // 按区间开始时间排序
        Arrays.sort(roomTimes, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        int[] cur = roomTimes[0];
        for (int i = 1; i < roomTimes.length; i++) {
            if (cur[1] >= roomTimes[i][0]) {
                cur[1] = Math.max(cur[1], roomTimes[i][1]);
            } else {
                res.add(cur);
                cur = roomTimes[i];
            }
        }
        // 加入最后一个区间
        res.add(cur);
        return res.toArray(new int[0][]);
    }
}
