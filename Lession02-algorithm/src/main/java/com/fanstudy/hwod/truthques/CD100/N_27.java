package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 悄悄话  层序遍历  父节点k, 子节点2k-1 ,2k+1
 */
public class N_27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        while (queue.size() > 0) {
            int fa = queue.removeLast();

            int ch_l = 2 * fa + 1;
            int ch_r = 2 * fa + 2;

            boolean ch_l_exist = ch_l < arr.length && arr[ch_l] != -1;
            boolean ch_r_exist = ch_r < arr.length && arr[ch_r] != -1;

            if (ch_l_exist) {
                arr[ch_l] += arr[fa];
                queue.addLast(ch_l);
            }

            if (ch_r_exist) {
                arr[ch_r] += arr[fa];
                queue.addLast(ch_r);
            }

            if (!ch_l_exist && !ch_r_exist) {
                ans = Math.max(ans, arr[fa]);
            }

        }
        System.out.println(ans);

    }
}
