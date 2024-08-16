package com.fanstudy.hwod.niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HJ26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        System.out.println(sortSrt(line));
    }

    private static String sortSrt(String str) {
        char[] chars = str.toCharArray();
        List<Character> letterList = new ArrayList<>();
        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                letterList.add(aChar);
            }
        }
        letterList.sort(Comparator.comparingInt(Character::toLowerCase));

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                sb.append(letterList.get(index++));
            } else {
                sb.append(chars[i]);
            }

        }

        return sb.toString();
    }
}
