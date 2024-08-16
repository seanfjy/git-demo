package com.fanstudy.hwod.niuke;

import java.util.Scanner;

/**
 * 牛客练习
 */
public class HJ16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int total_money = in.nextInt() / 10; // 总钱数
            int num = in.nextInt(); // 商品个数
            Goods[] goods = new Goods[num];
            for (int i = 0; i < num; i++) {
                goods[i] = new Goods();

            }
            for (int i = 0; i < num; i++) {
                goods[i].price = in.nextInt() / 10; // 价格
                goods[i].val = in.nextInt() * goods[i].price; // 价值
                int q = in.nextInt(); // 主or附件
                if (q == 0) {
                    goods[i].main = true;
                } else if (goods[q - 1].sub1 == -1) {
                    goods[q - 1].sub1 = i;
                } else {
                    goods[q - 1].sub2 = i;
                }
            }

            System.out.println(getMaxValue(goods, num, total_money) * 10);
        }
    }

    private static int getMaxValue(Goods[] goods, int num, int totalMoney) {
        int[][] dp = new int[num + 1][totalMoney + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= totalMoney; j++) {

                // 不购买该商品
                dp[i][j] = dp[i - 1][j];
                if (goods[i - 1].main) {
                    // 1. 只买主件
                    if (goods[i - 1].price <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].price] + goods[i - 1].val);
                    }

                    // 主+附1
                    if (goods[i - 1].sub1 != -1 && (goods[i - 1].price + goods[goods[i - 1].sub1].price) <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].price - goods[goods[i - 1].sub1].price]
                            + goods[i - 1].val + goods[goods[i - 1].sub1].val);
                    }
                    // 主+附2
                    if (goods[i - 1].sub2 != -1 && (goods[i - 1].price + goods[goods[i - 1].sub2].price) <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i - 1].price - goods[goods[i - 1].sub2].price]
                            + goods[i - 1].val + goods[goods[i - 1].sub2].val);
                    }
                    // 主+附1+附2
                    if (goods[i - 1].sub1 != -1 && goods[i - 1].sub2 != -1 && (goods[i - 1].price
                        + goods[goods[i - 1].sub1].price + goods[goods[i - 1].sub2].price) <= j) {
                        dp[i][j] = Math.max(dp[i][j],
                            dp[i - 1][j - goods[i - 1].price - goods[goods[i - 1].sub1].price
                                - goods[goods[i - 1].sub2].price] + goods[i - 1].val + goods[goods[i - 1].sub1].val
                                + goods[goods[i - 1].sub2].val);
                    }
                }

            }
        }

        return dp[num][totalMoney];
    }

    static class Goods {
        private int price;
        private int val;
        private boolean main;

        private int sub1 = -1;// 附件1的对应的物品下标

        private int sub2 = -1; // 附件1的对应的物品下标

    }

}
