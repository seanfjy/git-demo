package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 考勤信息
 */
public class N_55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[][] records = new String[n][];
        for (int i = 0; i < n; i++) {
            records[i] = in.nextLine().split(" ");
        }
        getResult(n, records);
    }

    private static void getResult(int n, String[][] records) {
        StringJoiner sj = new StringJoiner(" ");

        for (int i = 0; i < n; i++) {
            sj.add(String.valueOf(isAward(records[i])));
        }

        System.out.println(sj);
    }

    // 7的滑动窗口
    private static boolean isAward(String[] record) {
        // 总缺勤次数
        int absent = 0;
        // 滑动窗口正常上班的次数
        int present = 0;
            // 记录前一次的考勤记录
        String preRecord = "";

        for (int i = 0; i < record.length; i++) {
            if (i >= 7) {
                if ("present".equals(record[i - 7]))
                    present--;
            }
            String curRecord = record[i];

            switch (curRecord) {
                case "absent": {
                    if (++absent > 1)
                        return false;
                    break;
                }
                case "late":
                case "leaveearly": {
                    if ("late".equals(preRecord) || "leaveearly".equals(preRecord))
                        return false;
                    break;
                }
                case "present":
                    present++;
                    break;

            }
            preRecord = curRecord;
            int win_len = Math.min(i + 1, 7);
            if (win_len - present > 3)
                return false;

        }
        return true;
    }
}
