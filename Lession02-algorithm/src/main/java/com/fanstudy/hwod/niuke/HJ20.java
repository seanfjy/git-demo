package com.fanstudy.hwod.niuke;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(checkPassword(line));

        }
    }

    private static String checkPassword(String s) {
        // 1.长度超过8
        int length = s.length();
        if (length <= 8) {
            return "NG";
        }
        // 2.包括大小写字母.数字.其它符号,以上四种至少三种
        int count = 0;
        boolean x = false, X = false, y = false, z = false;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z')) {
                if (!x) {
                    count++;
                }
                x = true;
            } else if (c >= 'A' && c <= 'Z') {
                if (!X) {
                    count++;
                }
                X = true;
            } else if (c >= '0' && c <= '9') {
                if (!y) {
                    count++;
                }
                y = true;
            } else {
                if (!z) {
                    count++;
                }
                z = true;
            }
        }
        if (count < 3) {
            return "NG";
        }
        // 3.不能有长度大于2的包含公共元素的子串重复
        Set<String> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int end = i + 3;
            if (end<=length){
                String substring = s.substring(i, end);
                if (set.contains(substring)){
                    return "NG";
                }else {
                    set.add(substring);
                }
            }
            
        }
        

        return "OK";
    }

}
