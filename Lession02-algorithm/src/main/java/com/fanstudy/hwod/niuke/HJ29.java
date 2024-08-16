package com.fanstudy.hwod.niuke;

import java.util.Scanner;

public class HJ29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String plain = in.nextLine();
            System.out.println(encodeStr(plain));

            String enCode = in.nextLine();
            System.out.println(deCodeStr(enCode));
            break;

        }
    }

    private static String deCodeStr(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    if (c == 'a') {
                        sb.append('Z');
                    } else {
                        sb.append(Character.toUpperCase((char)(c - 1)));
                    }
                } else {
                    if (c == 'A') {
                        sb.append("z");
                    } else {
                        sb.append(Character.toLowerCase((char)(c - 1)));
                    }
                }

            } else if (Character.isDigit(c)) {
                if (c == '0') {
                    sb.append('9');
                } else {
                    sb.append((char)(c - 1));
                }

            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private static String encodeStr(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    if (c == 'z') {
                        sb.append('A');
                    } else {
                        sb.append(Character.toUpperCase((char)(c + 1)));
                    }

                } else {
                    if (c == 'Z') {
                        sb.append("a");
                    } else {
                        sb.append(Character.toLowerCase((char)(c + 1)));
                    }
                }

            } else if (Character.isDigit(c)) {
                if (c == '9') {
                    sb.append('0');
                } else {
                    sb.append((char)(c + 1));
                }

            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
