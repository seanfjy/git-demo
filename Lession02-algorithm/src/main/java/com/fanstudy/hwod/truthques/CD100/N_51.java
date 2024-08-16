package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 连续字母长度
public class N_51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int k = Integer.parseInt(in.nextLine());

        System.out.println(getRes(k, str));

    }

    private static int getRes(int k, String str) {

        if (k <= 0) {
            return -1;
        }
        HashMap<Character, Integer> cnt = new HashMap<>();
        str += "0";//保证cnt一定有值
        char b = str.charAt(0);
        int len = 1;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (b == c) {
                len++;
            } else {
                if (!cnt.containsKey(b) || cnt.get(b) < len) {
                    cnt.put(b, len);
                }
                len = 1;
                b = c;
            }
        }
        Integer[] arr = cnt.values().toArray(new Integer[0]);
        if (k > arr.length) {
            return -1;
        } else {
            Arrays.sort(arr, (a1, a2) -> a2 - a1);
            return arr[k - 1];
        }

    }
}
