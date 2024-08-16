package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 智能成绩表 动态排序 rank[] 建立排序类别映射
 */
public class N_07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        // 记录每个学科对应的索引
        Map<String, Integer> subjectMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            subjectMap.put(in.next(), i);
        }
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int[] rank = new int[m + 1];
            int sum = 0;
            for (int j = 0; j < m; j++) {
                rank[j] = in.nextInt();
                sum += rank[j];
            }
            rank[m] = sum;
            students[i] = new Student(name, rank);
        }
        String rankStr = in.next();
        Integer rankIndex = subjectMap.getOrDefault(rankStr, m);
        Arrays.sort(students, (o1, o2) -> o1.rank[rankIndex] != o2.rank[rankIndex]
            ? o2.rank[rankIndex] - o1.rank[rankIndex] : o1.name.compareTo(o2.name));
        StringJoiner sj = new StringJoiner(" ");
        for (Student student : students) {
            sj.add(student.name);
        }
        System.out.println(sj);

    }

    static class Student {
        private String name;

        private int[] rank;

        public Student(String name, int[] rank) {
            this.name = name;
            this.rank = rank;
        }
    }
}
