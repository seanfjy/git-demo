package com.fanstudy.hwod.niuke;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String key = in.next();
        String word = in.next();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        int length = key.length();
        Set<Integer> tempIndex = new HashSet<>();
        int a = 0;
        for (int i = 0; i < length; i++) {
            int index = key.charAt(i) - 'a';
            if (tempIndex.add(index)) {
                arr[a++] = index;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == -1) {
                for (int j = 0; j < 26; j++) {
                    if(tempIndex.add(j)){
                        arr[i]= j;
                        break;
                    }

                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = (char) (arr[(word.charAt(i) - 'a')] + 'a');
            sb.append(c);
        }
        System.out.println(sb);
    }
}
