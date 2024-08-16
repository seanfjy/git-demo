package com.fanstudy.hwod.niuke;

import java.util.Scanner;

public class HJ33 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String ipStr = in.nextLine();
        System.out.println(getIpNum(ipStr));
        long ipNum = in.nextLong();
        System.out.println(getIpStr(ipNum));

    }

    private static Long getIpNum(String ipStr) {
        StringBuilder sb = new StringBuilder();
        String[] split = ipStr.split("\\.");
        for (String str : split) {
            String binaryString = Integer.toBinaryString(Integer.parseInt(str));
            while (binaryString.length() < 8) {
                binaryString = "0" + binaryString;
            }
            sb.append(binaryString);
        }
        return Long.valueOf(sb.toString(), 2);
    }

    private static String getIpStr(long ipNum) {
        StringBuilder sb = new StringBuilder();
        String binaryString = Long.toBinaryString(ipNum);
        while (binaryString.length() < 32) {
            binaryString = "0" + binaryString;
        }
        String ip = "";
        for (int i = 0; i < 4; i++) {
            String substring = binaryString.substring(i * 8, i * 8 + 8);
            Long k = Long.valueOf(substring, 2);
            ip = ip + k;
            if (i < 3) {
                ip = ip + ".";
            }
        }

        return ip;
    }

}
