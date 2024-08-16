package com.fanstudy.hwod.truthques.CD100;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 数组去重和排序
 */
public class N_45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split(",");

        System.out.println(getResult(arr));

    }

    private static String getResult(String[] arr) {
        LinkedHashMap<String, Integer> cntMap = new LinkedHashMap<>();

        for (String s : arr) {
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
        }
        StringJoiner sj = new StringJoiner(",");
        cntMap.keySet().stream().sorted((a, b) -> cntMap.get(b) - cntMap.get(a)).forEach(sj::add);
        return sj.toString();

    }
}
