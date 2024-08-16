package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
 * 8 最长的指定瑕疵度的元音子串
 *
 * 双指针
 */
public class N_54 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flaw = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        System.out.println(getReusult(flaw, str));
    }

    private static int getReusult(int flaw, String str) {

        char[] yuan = {'a','e','i','o','u','A','E','I','O','U'};
        HashSet<Character> set = new HashSet<>();
        for (char c : yuan) {
            set.add(c);
        }
        ArrayList<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))){
                idxs.add(i);
            }
        }

        int ans = 0;
        int n = idxs.size();
        int l = 0;
        int r = 0;

        while (r<n){
            // 瑕疵度计算
            int diff = idxs.get(r)-idxs.get(l) -(r-l);
            if (diff>flaw){
                l++;
            }else if (diff< flaw){
                r++;
            }else {
                ans = Math.max(ans,idxs.get(r)-idxs.get(l)+1);
                r++;
            }
        }
     return ans;
    }
}
