package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 火星文计算2
 */
public class N_44 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Pattern compile = Pattern.compile("(\\d+)#(\\d+)");
        while (true) {
            Matcher matcher = compile.matcher(str);
            if (!matcher.find()) {
                break;
            }
            String subStr = matcher.group(0);
            long x = Long.parseLong(matcher.group(1));
            long y = Long.parseLong(matcher.group(2));

            str = str.replaceFirst(subStr, String.valueOf(4 * x + 3 * y + 2));

        }

        System.out
            .println(Arrays.stream(str.split("\\$")).map(Long::parseLong).reduce((x, y) -> 2 * x + y + 3).orElse(0L));

    }
}
