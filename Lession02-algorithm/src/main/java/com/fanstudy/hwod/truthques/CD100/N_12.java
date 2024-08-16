package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 内存冷热标记
 * 多条件排序
 *
 *哈希表,组数
 */
public class N_12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] count = new int[65535];
        for (int i = 0; i < n; i++) {
            count[in.nextInt()]++;
        }
        int t = in.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= t) {
                list.add(new int[] {i, count[i]});
            }
        }
        if (list.isEmpty()) {
            System.out.println(0);
        } else {
            list.sort((a1, a2) -> a1[1] != a2[1] ? a2[1] - a1[1] : a1[0] - a2[0]);
            System.out.println(list.size());
            list.forEach(e -> System.out.println(e[0]));
        }

    }

}
