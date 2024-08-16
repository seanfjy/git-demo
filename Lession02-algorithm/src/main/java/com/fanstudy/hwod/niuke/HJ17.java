package com.fanstudy.hwod.niuke;

import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = 0, y = 0;
        if (in.hasNextLine()) {
            String line = in.nextLine();
            String[] split = line.split(";");
            for (String str : split) {
                int length = str.length();
                if (length > 1 && length <= 3) {
                    char direction = str.charAt(0);
                    int step = 0;
                    for (int i = 1; i < length; i++) {
                        if (Character.isDigit(str.charAt(i))) {
                            step = step * 10 + str.charAt(i) - '0';
                        } else {
                            step = 0;
                            break;
                        }
                    }
                    switch (direction) {
                        case 'A': {
                            x -= step;
                            break;
                        }
                        case 'D': {
                            x += step;
                            break;
                        }
                        case 'W': {
                            y += step;
                            break;
                        }
                        case 'S': {
                            y -= step;
                            break;
                        }
                    }
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
