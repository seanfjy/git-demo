package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 开源项目热度榜单 排序,求出hot
 */
public class N_09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weight = new int[5];
        for (int i = 0; i < 5; i++) {
            weight[i] = in.nextInt();
        }
        List<Project> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = in.next();
            int hot = 0;
            for (int j = 0; j < 5; j++) {
                hot += in.nextInt() * weight[j];
            }
            list.add(new Project(name, hot));
        }

        list.sort(
            (p1, p2) -> p1.hot != p2.hot ? p2.hot - p1.hot : p1.name.toLowerCase().compareTo(p2.name.toLowerCase()));

        list.forEach(e -> System.out.println(e.name));

    }

    static class Project {
        private String name;
        private int hot;

        public Project(String name, int hot) {
            this.name = name;
            this.hot = hot;
        }
    }
}
