package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 执行时长
 */
public class N_58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxTask = in.nextInt();
        int n = in.nextInt();
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = in.nextInt();
        }

        System.out.println(getSolution(maxTask, tasks));

    }

    private static int getSolution(int maxTask, int[] tasks) {
        int remain = 0;
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            int task = tasks[i];
            if (remain + task >= maxTask) {
                remain = remain + task - maxTask;
                time++;
            } else {
                remain = 0;
                time++;
            }
        }
        while (remain > 0) {
            remain -= maxTask;
            time++;

        }
        return time;

    }
}
