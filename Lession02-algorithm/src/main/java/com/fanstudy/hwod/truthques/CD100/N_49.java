package com.fanstudy.hwod.truthques.CD100;

import java.util.Collections;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.TreeSet;

// 英文输入法
public class N_49 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String pre = in.nextLine();

        System.out.println(getResult(pre, str));
    }

    private static String getResult(String pre, String str) {
        String[] split = str.split("[^a-zA-Z]");
        TreeSet<String> cache = new TreeSet<>();
        Collections.addAll(cache, split);
        StringJoiner sj = new StringJoiner(" ");
        cache.stream().filter(s -> s.startsWith(pre)).forEach(sj::add);
        String ans = sj.toString();
        if (ans.length() > 0) {
            return ans;
        } else {
            return pre;
        }
    }
}
