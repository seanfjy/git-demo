package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 按身高和体重排队
 */
public class N_67 {

    static class Student {
        String no;
        int height;
        int weight;

        public Student(String no, int height) {
            this.no = no;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student(String.valueOf(i + 1) , in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            students[i].weight = in.nextInt();
        }
        Arrays.sort(students, (a, b) -> a.height != b.height ? a.height - b.height : a.weight - b.weight);

        StringJoiner sj  = new StringJoiner(" ");
        for (Student student : students) {
            sj.add(student.no);
        }
        System.out.println(sj);
    }
}
