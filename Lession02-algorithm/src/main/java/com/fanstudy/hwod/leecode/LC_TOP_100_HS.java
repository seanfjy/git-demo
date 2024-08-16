package com.fanstudy.hwod.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 回溯
 */
public class LC_TOP_100_HS {

    class LC_46 {
        private List<List<Integer>> ans = new ArrayList<>();
        private LinkedList<Integer> path = new LinkedList<>();
        private boolean[] visited;

        /**
         * 46. 全排列
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0) {
                return ans;
            }
            visited = new boolean[nums.length];
            permuteHelper(nums);
            return ans;

        }

        private void permuteHelper(int[] nums) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {

                if (visited[i]) {
                    continue;
                }
                path.add(nums[i]);
                visited[i] = true;
                permuteHelper(nums);
                path.removeLast();
                visited[i] = false;
            }

        }
    }

    class LC_78 {
        private List<List<Integer>> ans = new ArrayList<>();
        private LinkedList<Integer> path = new LinkedList<>();;

        /**
         * 78. 子集
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets(int[] nums) {

            dfs(0, nums);
            return ans;

        }

        private void dfs(int i, int[] nums) {
            if (i == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }
            dfs(i + 1, nums);

            path.add(nums[i]);
            dfs(i + 1, nums);
            path.removeLast();
        }
    }

    class LC_17 {
        /**
         * 17. 电话号码的字母组合
         *
         * @param digits
         * @return
         */
        public List<String> letterCombinations(String digits) {
            int n = digits.length();
            if (n == 0)
                return List.of();
            this.digits = digits.toCharArray();
            path = new char[n];
            dfs(0);
            return ans;

        }

        private void dfs(int i) {
            if (i == digits.length) {
                ans.add(new String(path));
                return;
            }
            char[] charArray = MAPPING[digits[i] - '0'].toCharArray();
            for (char c : charArray) {
                path[i] = c;
                dfs(i + 1);
            }
        }

        private static final String[] MAPPING =
            new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        private List<String> ans = new ArrayList<>();
        private char[] digits, path;
    }

    class LC_39 {

        /**
         * 39. 组合总和
         *
         * @param candidates
         * @param target
         * @return
         */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(0, target, candidates, ans, path);
            return ans;
        }

        private void dfs(int i, int target, int[] candidates, List<List<Integer>> ans, List<Integer> path) {
            if (target == 0) {
                // 找到一个合法组合
                ans.add(new ArrayList<>(path));
                return;
            }
            if (i == candidates.length || target < candidates[i]) {
                return;
            }

            // 不选
            dfs(i + 1, target, candidates, ans, path);

            // 选
            path.add(candidates[i]);
            dfs(i, target - candidates[i], candidates, ans, path);
            path.remove(path.size() - 1);

        }
    }

    /**
     * 22. 括号生成
     */
    class LC_22 {
        public List<String> generateParenthesis(int n) {
            this.n = n;
            path = new char[n * 2];
            dfs(0, 0);
            return ans;

        }

        // open 左括号的个数,i-open = 右括号的个数
        private void dfs(int i, int open) {
            if (i == 2 * n) {
                ans.add(new String(path));
                return;
            }
            // 可以填左括号
            if (open < n) {
                path[i] = '(';// 直接覆盖
                dfs(i + 1, open + 1);// 左括号+1
            }
            // 可以填右括号
            if (i - open < open) {
                path[i] = ')';// 直接覆盖
                dfs(i + 1, open);
            }
        }

        private int n;
        private char[] path;
        private List<String> ans = new ArrayList<>();
    }

    /**
     * 79. 单词搜索
     */
    class LC_79 {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            if (m * n < word.length()) {
                return false;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (check(board, i, j, word, 0)) {
                            return true;
                        }
                    }
                }
            }
            return false;

        }

        private boolean check(char[][] board, int i, int j, String word, int index) {
            if (index == word.length()) {
                return true;
            }
            if (!inArea(board, i, j) || board[i][j] != word.charAt(index)) {
                return false;
            }
            board[i][j] = '*';// visited

            boolean result = check(board, i - 1, j, word, index + 1) || check(board, i + 1, j, word, index + 1)
                || check(board, i, j - 1, word, index + 1) || check(board, i, j + 1, word, index + 1);

            board[i][j] = word.charAt(index);// 恢复现场
            return result;
        }

        private boolean inArea(char[][] board, int i, int j) {
            return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
        }

    }

    /**
     * 131. 分割回文串
     */
    class LC_131 {
        public List<List<String>> partition(String s) {
            this.s = s;
            dfs(0);
            return ans;
        }

        // 枚举子串结束位置
        private void dfs(int i) {
            if (i == s.length()) {
                ans.add(new ArrayList<>(path));
            }

            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(i, j)) {
                    path.add(s.substring(i, j + 1));
                    dfs(j + 1);
                    path.remove(path.size() - 1);
                }
            }

        }

        private boolean isPalindrome(int left, int right) {
            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }

        private List<List<String>> ans = new ArrayList<>();
        private List<String> path = new ArrayList<>();
        private String s;
    }

    /**
     * 51. N 皇后
     */
    class LC_51 {
        public List<List<String>> solveNQueens(int n) {
            chessboard = new int[n];
            Arrays.fill(chessboard, -1);
            dfs(0, n);
            return ans;

        }

        private void dfs(int row, int n) {
            if (row == n) {
                List<String> list = helper(path);
                ans.add(list);
                return;
            }
            for (int col = 0; col < n; col++) {
                // 判断(row,col)能否放皇后，不能放皇后，则越过
                if (!isValid(row, col, chessboard)) {
                    continue;
                }
                path.add(col);
                chessboard[row] = col;
                dfs(row + 1, n);
                path.remove(path.size() - 1);
                chessboard[row] = -1;

            }
        }

        private boolean isValid(int row, int col, int[] chessboard) {

            for (int i = 0; i < row; i++) {
                if (chessboard[i] == col) {
                    return false;
                }
                if (i + chessboard[i] == row + col) {
                    return false;
                }
                if (i - chessboard[i] == row - col) {
                    return false;
                }

            }
            return true;
        }

        private List<String> helper(List<Integer> path) {
            List<String> board = new ArrayList<>();
            int size = path.size();
            for (int i = 0; i < size; i++) {
                char[] temp = new char[size];
                Arrays.fill(temp, '.');
                temp[path.get(i)] = 'Q';
                board.add(new String(temp));
            }
            return board;
        }

        private List<List<String>> ans = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();// 存储第i行的皇后在第path.get(i)列

        private int[] chessboard;// 存储第i行的皇后在第chessboard[i]列
    }

}
