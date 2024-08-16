package com.fanstudy.hwod.truthques.CD100;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 机场航班调度程序
 * 字符串排序
 */
public class N_30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringJoiner sj = new StringJoiner(",");
        Arrays.stream(in.nextLine().split(",")).sorted((a1, a2)->{
            String s1 = a1.substring(0, 2);
            String s2 = a2.substring(0, 2);
            int num1 =  Integer.parseInt(a1.substring(2)) ;
            int num2 =  Integer.parseInt(a2.substring(2)) ;

            return s1.equals(s2)? num1-num2:s1.compareTo(s2);

        }).forEach(sj::add);
        System.out.println(sj);
    }
}
