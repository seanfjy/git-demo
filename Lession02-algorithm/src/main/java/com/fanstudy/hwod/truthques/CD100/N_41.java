package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 测试用例执行计划
 * 多条件排序
 */
public class N_41 {

    static class TestCase {
        int id;
        int priority;

        public TestCase(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] temp = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = temp[0];
        int m = temp[1];

        int[] feature = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            feature[i] = Integer.parseInt(in.nextLine());
        }
        ArrayList<TestCase> cases = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            int priority = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).map(id -> feature[id])
                .reduce(Integer::sum).orElse(0);
            cases.add(new TestCase(i, priority));
        }

        cases.stream().sorted((a, b) -> a.priority != b.priority ? b.priority - a.priority : a.id - b.id)
            .map(testCase -> testCase.id).forEach(System.out::println);

    }
}
