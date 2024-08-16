package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提取字符串中的最长合法简单数学表达式
 *
 * 正则
 * 正则表达式 (-?\d+)([+*-])(\d+)
 * 用于匹配和捕获由两个整数和一个数学运算符（+、* 或 -）组成的表达式
 */
public class N_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Pattern compile = Pattern.compile("(-?\\d+)([+*-])(\\d+)");
        int maxExpLen = 0;
        long ans = 0;

        for (int i = 0; i < str.length(); i++) {
            // 剩余长度小于最大表达式,结束
            if (str.length() - i <= maxExpLen) {
                break;
            }
            for (int j = i; j < str.length(); j++) {
                String sub = str.substring(i, j + 1);
                Matcher matcher = compile.matcher(sub);
                if (matcher.find() && sub.length() > maxExpLen) {
                    maxExpLen = sub.length();
                    long op_num1 = Long.parseLong(matcher.group(1));
                    String op = matcher.group(2);
                    long op_num2 = Long.parseLong(matcher.group(3));

                    switch (op) {
                        case "*": {
                            ans = op_num1 * op_num2;
                            break;
                        }
                        case "+": {
                            ans = op_num1 + op_num2;
                            break;
                        }
                        case "-": {
                            ans = op_num1 - op_num2;
                            break;
                        }
                    }
                }

            }
        }
        System.out.println(ans);
    }
}
