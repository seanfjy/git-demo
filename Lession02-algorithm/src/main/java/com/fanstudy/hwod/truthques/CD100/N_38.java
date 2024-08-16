package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 8 小朋友来自多少小区
 */
public class N_38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] garden = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(garden));
    }

    private static int getResult(int[] garden) {
        HashMap<Integer, Integer> cnts = new HashMap<>();
        for (int num : garden) {
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Integer key : cnts.keySet()) {
            int total = key + 1;
            ans += Math.ceil(cnts.get(key) * 1.0 / total) * total;
        }
        return ans;
    }
}
