package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 整数对最小和
 */
public class N_61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = in.nextInt();
        }
        int k = in.nextInt();

        System.out.println(getResult(k, arr1, arr2));
    }

    private static int getResult(int k, int[] arr1, int[] arr2) {

        List<Integer> pairs = new ArrayList<>();

        for (int i : arr1) {
            for (int j : arr2) {
                pairs.add(i + j);
            }
        }
        pairs.sort((a, b) -> a - b);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += pairs.get(i);
        }
        return ans;
    }
}
