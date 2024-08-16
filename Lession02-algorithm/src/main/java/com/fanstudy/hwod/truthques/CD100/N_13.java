package com.fanstudy.hwod.truthques.CD100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 虚拟理财游戏  暴力枚举
 */
public class N_13 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int totalAmount = in.nextInt();
        int totalRisk = in.nextInt();
        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {
            products[i] = new Product();
        }
        for (int i = 0; i < n; i++) {
            products[i].backRate = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            products[i].riskValue = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            products[i].maxAmount = in.nextInt();
        }
        int max_back = 0;
        // 选则的产品及投资额
        Map<Integer, Integer> select = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Product product = products[i];

            // 先选第一个
            if (product.riskValue <= totalRisk) {
                int amount = Math.min(totalAmount, product.maxAmount);
                int back = product.getBack(amount);
                if (back > max_back) {
                    max_back = back;
                    select.clear();;
                    select.put(i, amount);
                }

            } else {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                Product productTwo = products[j];
                if (product.riskValue + productTwo.riskValue <= totalRisk) {
                    int amountI;
                    int amountJ;
                    // 回报率大的多买
                    if (product.backRate > productTwo.backRate) {
                        amountI = Math.min(totalAmount, product.maxAmount);
                        amountJ = Math.min(totalAmount - amountI, productTwo.maxAmount);
                    } else {
                        amountJ = Math.min(totalAmount, productTwo.maxAmount);
                        amountI = Math.min(totalAmount - amountJ, product.maxAmount);
                    }
                    int back = product.getBack(amountI) + productTwo.getBack(amountJ);
                    if (back > max_back) {
                        max_back = back;
                        select.clear();
                        if (amountI > 0) {
                            select.put(i, amountI);
                        }
                        if (amountJ > 0) {
                            select.put(j, amountJ);
                        }
                    }

                }
            }

        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < n; i++) {
            if (select.containsKey(i)) {
                sj.add(String.valueOf(select.get(i)));
            } else {
                sj.add("0");
            }
        }
        System.out.println(sj);

    }

    static class Product {
        private int backRate;

        private int riskValue;

        private int maxAmount;

        public int getBack(int amount) {
            return backRate * amount;
        }

    }
}
