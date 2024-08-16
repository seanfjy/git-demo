package com.fanstudy.hwod.truthques.CD100;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 求满足条件的最长子串的长度
 *
 * 滑动窗口 记录字母索引,保证只有一个字母
 */
public class N_47 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(getResult(in.nextLine()));
    }

    private static int getResult(String s) {
        int length = s.length();
        int maxLen = -1;
        int l = 0, r = 0;
        boolean hasLetter = false;
        LinkedList<Integer> letterIdx = new LinkedList<>();

        while (r < length) {
            char c = s.charAt(r);
            if (Character.isLetter(c)) {
                hasLetter = true;
                letterIdx.add(r);
                if (letterIdx.size() > 1) {
                    l = letterIdx.removeFirst() + 1;
                }
            }
            if (r == l) {
                r++;
                continue;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        if (!hasLetter){
            return -1;
        }
        return maxLen;

    }
}
