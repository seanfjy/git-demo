package com.fanstudy.hwod.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 动态规划
 */
public class LC_TOP_100_DP {

    /**
     * 70. 爬楼梯
     */
    class LC_70 {
        // 递归
        public int climbStairs(int n) {
            int[] memo = new int[n + 1];
            return dfs(n, memo);
        }

        // 递推
        public int climbStairsTwo(int n) {
            int[] f = new int[n + 1];
            f[0] = f[1] = 1;
            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
            return f[n];
        }

        private int dfs(int i, int[] memo) {
            if (i <= 1) {
                return 1;
            }
            if (memo[i] != 0) {// 之前计算过
                return memo[i];
            }
            return memo[i] = dfs(i - 1, memo) + dfs(i - 2, memo);// 记忆化
        }

        private int dfs(int i) {
            if (i <= 1) {
                return 1;
            }
            return dfs(i - 1) + dfs(i - 2);
        }
    }

    /**
     * 118. 杨辉三角
     */
    class LC_118 {

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>(numRows);
            ans.add(List.of(1));

            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>(i + 1);
                row.add(1);
                for (int j = 1; j < i; j++) {
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
                row.add(1);
                ans.add(row);

            }
            return ans;

        }

    }

    /**
     * 198. 打家劫舍
     */
    class LC_198 {
        private int[] nums, memo;

        public int rob(int[] nums) {
            int n = nums.length;
            this.nums = nums;
            memo = new int[n];
            Arrays.fill(memo, -1);

            return dfs(n - 1);

        }

        // 递推
        public int robTwo(int[] nums) {
            int n = nums.length;
            int[] f = new int[n + 2];
            for (int i = 0; i < n; i++) {
                f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
            }
            return f[n + 1];

        }

        public int robThree(int[] nums) {
            int n = nums.length;
            int f0 = 0, f1 = 0;
            for (int i = 0; i < n; i++) {
                int fNew = Math.max(f1, f0 + nums[i]);
                f0 = f1;
                f1 = fNew;
            }
            return f1;

        }

        private int dfs(int i) {
            if (i < 0) {
                return 0;
            }
            if (memo[i] != -1) {
                return memo[i];
            }
            int res = Math.max(dfs(i - 1), dfs(i - 2) + nums[i]);
            memo[i] = res;
            return res;
        }

    }

    /**
     * 279. 完全平方数
     */
    class LC_279 {

        private int[][] memo = new int[101][10001];

        public int numSquares(int n) {
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dfs((int)Math.sqrt(n), n);
        }

        private int dfs(int i, int j) {
            if (i == 0) {
                return j == 0 ? 0 : Integer.MAX_VALUE;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            if (j < i * i) {
                return memo[i][j] = dfs(i - 1, j);// 只能不选
            }
            return memo[i][j] = Math.min(dfs(i - 1, j), dfs(i, j - i * i) + 1); // 不选或选
        }
    }

    /**
     * 322. 零钱兑换
     */
    class LC_322 {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            this.coins = coins;
            memo = new int[n][10001];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }
            int res = dfs(n - 1, amount);
            return res < Integer.MAX_VALUE / 2 ? res : -1;
        }

        // 递推
        public int coinChangeTwo(int[] coins, int amount) {
            int n = coins.length;
            int[][] f = new int[n + 1][amount + 1];
            Arrays.fill(f[0], Integer.MAX_VALUE / 2);
            f[0][0] = 0;
            for (int i = 0; i < n; i++) {
                for (int c = 0; c <= amount; c++) {
                    if (c < coins[i]) {
                        f[i + 1][c] = f[i][c];
                    } else {
                        f[i + 1][c] = Math.min(f[i][c], f[i + 1][c - coins[i]] + 1);
                    }

                }
            }

            int res = f[n][amount];
            return res < Integer.MAX_VALUE / 2 ? res : -1;
        }

        private int dfs(int i, int c) {
            if (i < 0) {
                return c == 0 ? 0 : Integer.MAX_VALUE / 2; // 除2防止下面+1溢出
            }
            if (memo[i][c] != -1) {
                return memo[i][c];
            }
            if (c < coins[i]) {
                return memo[i][c] = dfs(i - 1, c);
            }

            return memo[i][c] = Math.min(dfs(i - 1, c), dfs(i, c - coins[i]) + 1);
        }

        private int[] coins;
        private int[][] memo;
    }

    /**
     * 139. 单词拆分
     */
    class LC_139 {
        /*        动态规划算法，dp[i]表示s前i个字符能否拆分
        转移方程：dp[j] = dp[i] && check(s[i+1, j]);
        check(s[i+1, j])就是判断i+1到j这一段字符是否能够拆分
        其实，调整遍历顺序，这等价于s[i+1, j]是否是wordDict中的元素
        这个举个例子就很容易理解。
        假如wordDict=["apple", "pen", "code"],s = "applepencode";
        dp[8] = dp[5] + check("pen")
        翻译一下：前八位能否拆分取决于前五位能否拆分，加上五到八位是否属于字典
        （注意：i的顺序是从j-1 -> 0哦~*/
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            Set<String> wordDictSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[n + 1];

            dp[0] = true;
            for (int j = 1; j <= n; j++) {
                for (int i = j - 1; i >= 0; i--) {
                    dp[j] = dp[i] && wordDictSet.contains(s.substring(i, j));
                    if (dp[j]) {
                        break;
                    }
                }
            }
            return dp[n];

        }

    }

    /**
     * 300. 最长递增子序列
     */
    class LC_300 {
        public int lengthOfLIS(int[] nums) {

            int n = nums.length;
            int ans = 0;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                ans = Math.max(dp[i], ans);
            }
            return ans;
        }
    }

    /**
     * 152. 乘积最大子数组
     */
    class LC_152 {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            double[] dp_max = new double[n];
            double[] dp_min = new double[n];
            dp_max[0] = dp_min[0] = nums[0];
            int ans = nums[0];
            for (int i = 1; i < n; i++) {
                dp_max[i] = Math.max(nums[i], Math.max(dp_max[i - 1] * nums[i], dp_min[i - 1] * nums[i]));
                dp_min[i] = Math.min(nums[i], Math.min(dp_min[i - 1] * nums[i], dp_max[i - 1] * nums[i]));
                ans = (int)Math.max(ans, dp_max[i]);
            }

            return ans;

        }
    }

    /**
     * 416. 分割等和子集
     */
    class LC_416 {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if ((sum & 1) == 1) {
                return false;
            }
            int m = sum / 2;
            boolean[][] f = new boolean[n + 1][m + 1];
            f[0][0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (j >= nums[i - 1]) {
                        f[i][j] = f[i - 1][j - nums[i - 1]] || f[i - 1][j];
                    } else {
                        f[i][j] = f[i - 1][j];
                    }
                }
            }
            return f[n][m];
        }
    }

    class LC_32 {
        // 栈
        public int longestValidParenthesesTwo(String s) {
            int ans = 0;
            Deque<Integer> stack = new LinkedList<>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        ans = Math.max(ans, i - stack.peek());
                    }
                }

            }
            return ans;
        }

        // 动态规划
        /*
        * 紧盯子问题与大问题之间的联结点
        关注联结点：子串的末位s[i]，它要么是'('，要么是')'：
        
        1.s[i]是'('，以它为结尾的子串，肯定不是有效括号子串——dp[i] = 0
        2.s[i]是')'，以它为结尾的子串可能是有效子串，还需考察前一个子问题的末尾s[i-1]
            a.s[i-1]是'('，s[i-1]和s[i]组成一对，有效长度保底为 2，还需考察s[i-2]：
                a.s[i-2]不存在，则有效长度只有 2——dp[i] = 2
                b.s[i-2]存在，则加上以s[i-2]为结尾的最长有效长度——dp[i]=dp[i-2]+2
            b.s[i-1]是')'，s[i-1]和s[i]是'))'，以s[i-1]为结尾的最长有效长度为dp[i-1]，跨过这个长度（具体细节不用管，总之它最大能提供dp[i-1]长度），来看s[i-dp[i-1]-1]这个字符：
                a.s[i-dp[i-1]-1]不存在或为')'，则s[i]找不到匹配，直接gg——dp[i]=0
                b.s[i-dp[i-1]-1]是'('，与s[i]匹配，有效长度 = 2 + 跨过的dp[i-1]+ 前方的dp[i-dp[i-1]-2]。等一下，s[i-dp[i-1]-2]要存在才行！：
                    a.s[i-dp[i-1]-2]存在，dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
                    b.s[i-dp[i-1]-2]不存在，dp[i] = dp[i-1] + 2
        base case ：dp[0] = 0 一个括号形成不了有效子串
        */
        public int longestValidParentheses(String s) {
            int n = s.length();
            int ans = 0;
            int[] dp = new int[n];
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    ans = Math.max(ans, dp[i]);
                }
            }
            return ans;
        }

    }

    // 多维动态规划

    /**
     * 62. 不同路径
     */
    class LC_62 {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            Arrays.fill(dp[0], 1);
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m - 1][n - 1];
        }
    }

    /**
     * 64. 最小路径和
     */
    class LC_64 {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            int sum = 0;
            // 初始化第一行
            for (int i = 0; i < m; i++) {
                sum += grid[i][0];
                dp[i][0] = sum;
            }
            sum = 0;
            // 初始化第一列
            for (int i = 0; i < n; i++) {
                sum += grid[0][i];
                dp[0][i] = sum;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    /**
     * 5. 最长回文子串
     */
    class LC_5 {
        public String longestPalindrome(String s) {

            int n = s.length();
            if (n < 2) {
                return s;
            }
            int left = 0, right = 0, maxLen = 0;
            boolean[][] dp = new boolean[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        if (j - i > maxLen) {
                            maxLen = j - i;
                            left = i;
                            right = j;
                        }
                    }

                }
            }
            return s.substring(left, right + 1);

        }

    }

    /**
     * 1143. 最长公共子序列
     */
    class LC_1143 {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[len1][len2];

        }
    }

    /**
     * 72. 编辑距离
     */
    class LC_72 {
        public int minDistance(String word1, String word2) {
            int M = word1.length();
            int N = word2.length();
            int[][] dp = new int[M + 1][N + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = i;

            }
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    }

                }
            }

            return dp[M][N];

        }
    }

    /**
     * 31. 下一个排列
     */
    class LC_31 {
        public void nextPermutation(int[] nums) {

            int len = nums.length;
            int min_index = -1;
            // 1. 找到 min_index，即从右往左第一个 nums[i] < nums[i+1] 的位置
            for (int i = len - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    min_index = i;
                    break;
                }
            }
            // 如果 min_index 为 -1，说明整个数组是非递增的，直接逆置整个数组
            if (min_index == -1) {
                reverse(nums, 0, len - 1);
                return;
            }
            int max_index = -1;
            // 2. 找到 max_index，即从右往左第一个大于 nums[min_index] 的位置
            for (int i = len - 1; i > min_index; i--) {
                if (nums[i] > nums[min_index]) {
                    max_index = i;
                    break;
                }
            }
            // 3. 交换 min_index 和 max_index 的元素
            swap(nums, min_index, max_index);

            // 4. 逆置 min_index + 1 到末尾的部分
            reverse(nums, min_index + 1, len - 1);

        }

        private void reverse(int[] nums, int l, int r) {
            while (l < r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }

        private void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }

    /**
     * 287. 寻找重复数
     */
    class LC_287{
        public int findDuplicate(int[] nums) {
            int slow = 0;
            int fast = 0;
            slow = nums[slow];
            fast = nums[nums[fast]];
            while(slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            int pre1 = 0;
            int pre2 = slow;
            while(pre1 != pre2){
                pre1 = nums[pre1];
                pre2 = nums[pre2];
            }
            return pre1;

        }
    }

}
