package com.fanstudy.hwod.truthques.CD100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 密码输入检测
 * 栈的特性 在尾部操作保证顺序
 */
public class N_05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] password = in.nextLine().toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : password) {
            if (c == '<') {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(c);
            }
        }
        int countUpper = 0;
        int countLower = 0;
        int countNum = 0;
        int countOther = 0;
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            if (character >= 'A' && character <= 'Z') {
                countUpper++;
            } else if (character >= 'a' && character <= 'z') {
                countLower++;
            } else if (character >= '0' && character <= '9') {
                countNum++;
            } else {
                countOther++;
            }
            sb.append(character);
        }
        if (password.length >= 8 && countLower > 0 && countUpper > 0 && countNum > 0 && countOther > 0) {
            sb.append(",true");
        } else {
            sb.append(",false");
        }
        System.out.println(sb);

    }
}
