package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求最多可以派出多少支团队
 */
public class N_72 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] persons = new int[n];
        for (int i = 0; i < n; i++) {
            persons[i] = in.nextInt();
        }
        int ability = in.nextInt();
        System.out.println(getResult(n, ability, persons));
    }

    private static int getResult(int n, int ability, int[] persons) {

        Arrays.sort(persons);
        int ans = 0;
        int l = 0;
        int r = n - 1;
        // 单人
        while (r >= l && persons[r] >= ability) {
            ans++;
            r--;
        }
        // 双人
        while (l < r) {
            if (persons[l] + persons[r] >= ability) {
                ans++;
                l++;
                r--;
            } else {
                l++;
            }
        }
        return ans;

    }
}
