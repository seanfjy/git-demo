package com.fanstudy.hwod.truthques.CD200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 石头剪刀布游戏
 * 逻辑分析
 */
public class H_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, List<String>> map = new HashMap<>();
        while (in.hasNextLine()) {

            String[] split = in.nextLine().split(" ");
            if (split.length != 2) {
                break;
            }
            List<String> names = map.getOrDefault(split[1], new ArrayList<>());
            names.add(split[0]);
            map.put(split[1], names);

        }
        Set<String> keys = map.keySet();
        if (keys.size() == 2) {
            if (!keys.contains("A")){
                List<String> list = map.get("B");
                list.sort(String::compareTo);
                for (String s : list) {
                    System.out.println(s);
                }

            }else if(!keys.contains("B")){
                List<String> list = map.get("C");
                list.sort(String::compareTo);
                for (String s : list) {
                    System.out.println(s);
                }
            }else {
                List<String> list = map.get("A");
                list.sort(String::compareTo);
                for (String s : list) {
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("NULL");
        }

    }
}
