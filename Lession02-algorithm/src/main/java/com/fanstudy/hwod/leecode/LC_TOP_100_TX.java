package com.fanstudy.hwod.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 贪心算法
 */
public class LC_TOP_100_TX {

    /**
     * 121. 买卖股票的最佳时机
     */
    class LC_121 {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int min = prices[0];
            for (int i = 0; i < prices.length; i++) {
                int price = prices[i];
                if (price >= min) {
                    maxProfit = Math.max(maxProfit, price - min);
                }
                min = Math.min(min, price);

            }
            return maxProfit;

        }
    }

    /**
     * 55. 跳跃游戏
     */
    class LC_55 {
        public boolean canJump(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > max) {
                    return false;
                }
                max = Math.max(max, i + nums[i]);
            }
            return true;
        }
    }

    /**
     * 45. 跳跃游戏 II
     */
    class LC_45 {
        public int jump(int[] nums) {

            int len = nums.length;
            int posMax = 0;
            int end = 0;
            int step = 0;
            for (int i = 0; i < len; i++) {
                posMax = Math.max(posMax, i + nums[i]);
                if (end == i) {
                    end = posMax;
                    step++;
                }
            }
            return step;

        }
    }

    /**
     * 763. 划分字母区间
     */
    class LC_763 {
        public List<Integer> partitionLabels(String s) {
            int n = s.length();
            char[] sCharArray = s.toCharArray();
            int[] last = new int[26];
            for (int i = 0; i < n; i++) {
                last[sCharArray[i] - 'a'] = i;// 每个字幕最后出现的下标
            }
            List<Integer> ans = new ArrayList<>();
            int start = 0, end = 0;
            for (int i = 0; i < n; i++) {
                // 更新当前区间右端点的最大值
                end = Math.max(end, last[sCharArray[i] - 'a']);
                if (end == i) {// 当前区间合并完成
                    ans.add(end - start + 1); // 将区间长度假如答案
                    start = i + 1; // 下一个区间的左端点
                }
            }
            return ans;
        }
    }
}
