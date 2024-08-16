package com.fanstudy.hwod.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.next();
        }
        String targetStr = in.next();
        int k = in.nextInt();

        char[] charArray = targetStr.toCharArray();
        Arrays.sort(charArray);
        String key = new String(charArray);
        List<String> ansList = new ArrayList<>();
        // 先进行字典升序排列
        Arrays.sort(words);
        for (String word : words) {
            if (word.equals(targetStr) || word.length()!= targetStr.length()){
                continue;
            }
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            if (key.equals(newStr)) {
                ansList.add(word);

            }
        }
        int count = ansList.size();
        System.out.println(count);
        if (k <= count) {
            System.out.println(ansList.get(k - 1));
        }

    }
}
