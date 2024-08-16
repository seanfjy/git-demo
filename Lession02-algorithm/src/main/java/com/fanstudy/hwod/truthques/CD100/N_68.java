package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * 解密犯罪时间
 */
public class N_68 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(":");
        String hour = split[0];
        String minute = split[1];

        System.out.println(getResult(hour, minute));

    }

    static Pattern pattern = Pattern.compile("(([01][0-9])|([2][0-3]))[0-5][0-9]");

    private static String getResult(String hour, String minute) {

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < hour.length(); i++) {
            set.add(hour.charAt(i));
        }
        for (int i = 0; i < minute.length(); i++) {
            set.add(minute.charAt(i));
        }
        LinkedList<Character> path = new LinkedList<>();
        ArrayList<String> ans = new ArrayList<>();
        dfs(set, path, ans);

        ans.sort(String::compareTo);
        String recentTime;
        int index = ans.indexOf(hour + minute);
        if (index == ans.size() - 1) {
            recentTime = ans.get(0);
        } else {
            recentTime = ans.get(index + 1);
        }
        String[] split = recentTime.split("");
        split[1] += ":";
        return String.join("", split);

    }

    private static void dfs(HashSet<Character> set, LinkedList<Character> path, ArrayList<String> ans) {

        if (path.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (Character character : path) {
                sb.append(character);
            }
            String tempStr = sb.toString();
            if (pattern.matcher(tempStr).find()) {
                ans.add(tempStr);
            }
            return;

        }

        for (Character character : set) {
            path.add(character);
            dfs(set, path, ans);
            path.removeLast();
        }

    }

}
