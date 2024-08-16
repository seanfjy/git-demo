package com.fanstudy.hwod.leecode;

public class SomeTest {
    public static void main(String[] args) {
        int targetSum = 150;
        int combinationCount = countCombinations(targetSum);
        System.out.println("Total number of combinations: " + combinationCount);
    }

    public static int countCombinations(int targetSum) {
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;  // There's one way to make zero: use no numbers at all.

        int[] numbers = {1, 2, 7};

        for (int number : numbers) {
            for (int i = number; i <= targetSum; i++) {
                dp[i] += dp[i - number];
            }
        }

        return dp[targetSum];
    }
}
