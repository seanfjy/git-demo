package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 字符串序列判定
 */
public class N_53 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String l = in.nextLine();

        System.out.println(getResult(s,l));

    }

    private static int getResult(String s, String l) {

          int i = 0;
          int j = 0;
          int ans =-1;
          while (i<s.length()&&j<l.length()){
              if (s.charAt(i)==l.charAt(j)){
                  i++;
                  ans = j;
              }
              j++;
          }
          return ans;
    }
}
