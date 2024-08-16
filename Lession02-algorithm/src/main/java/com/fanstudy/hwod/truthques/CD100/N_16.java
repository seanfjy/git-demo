package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 万能字符单词拼写  单个字符差 <=万能字符数
 */
public class N_16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.next();
        }
        String chars = in.next();

        System.out.println(getResult(words,n,chars));
    }

    private static int getResult(String[] words, int n, String chars) {
        int ans = 0;
        int[] cnt_chars = charStatistic(chars);

        for (int i = 0; i < n; i++) {
            int diff = 0;
            int[] cnt_word = charStatistic(words[i]);

            for (int j = 0; j < 128; j++) {
                diff += Math.max(cnt_word[j]-cnt_chars[j],0);
            }
            if (diff <= cnt_chars['?']){
                ans++;
//                System.out.println(words[i]);
            }

        }
        return ans;

    }

    private static int[] charStatistic(String s) {
        int[] cnts = new int[128];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i)]++;
        }
        return cnts;

    }
}
