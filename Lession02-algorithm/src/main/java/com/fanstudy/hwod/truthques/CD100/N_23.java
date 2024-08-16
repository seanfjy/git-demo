package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * API集群负载统计
 *字符统计,集合
 *
 */
public class N_23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Map<String, Integer>> cnts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] levelNames = in.next().split("/");

            for (int level = 0; level < levelNames.length; level++) {
                String levelName = levelNames[level];
                if (cnts.size() <= level) {
                    cnts.add(new HashMap<>());
                }
                Map<String, Integer> stringIntegerMap = cnts.get(level);
                stringIntegerMap.put(levelName, stringIntegerMap.getOrDefault(levelName, 0) + 1);
            }

        }

        int target_level = in.nextInt();
        String target_Name = in.next();
        if (target_level >= cnts.size()) {
            System.out.println(0);
        } else {
            System.out.println(cnts.get(target_level).getOrDefault(target_Name, 0));
        }
    }
}
