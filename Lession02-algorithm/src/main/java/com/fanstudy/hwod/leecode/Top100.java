package com.fanstudy.hwod.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Top100 {
    public static void main(String[] args) {
        Top100 top100 = new Top100();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        top100.maxSlidingWindow(nums, k);
    }

    /**
     * 1. 两数之和 哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        /*   Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int numTwo = target - nums[i];
            if (map.containsKey(numTwo)) {
                res[0] = map.get(numTwo);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        
        }
        return res;*/
        // 哈希表记录key-数值,value-下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果目标和-当前数值 存在返回结果
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                // 将当前数值-下标加入到哈希表中
                map.put(nums[i], i);
            }
        }
        return new int[2];

    }

    /**
     * 49. 字母异位词分组 哈希表 -排序
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagramsOne(String[] strs) {
        // 排序后的字符串可以利用哈希表的key进行分组
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            // 排序
            Arrays.sort(charArray);
            // 得到key
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 49. 字母异位词分组 哈希表-计数
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagramsTwo(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int len = str.length();
            for (int i = 0; i < len; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于0的字母和出现次数按顺序拼接成字符串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char)('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 128. 最长连续序列
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        // 去重
        Set<Integer> nums_set = new HashSet<>();
        for (int num : nums) {
            nums_set.add(num);
        }
        // 记录最长连续序列的长度
        int longestStreak = 0;
        for (int num : nums_set) {
            // 判断是否是第一个值 ,因为是连续的,所以上一个值为当前值-1
            if (!nums_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                // 判断下一个值,当前值+1
                while (nums_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                // 获取最大的序列长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    /**
     * 283. 移动零 两次遍历
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;// 记录非零数移动下标
        // 第一个遍历,将不是0的往前移动
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        // 将剩余的都置为0
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 283. 移动零 一次遍历
     *
     * @param nums
     */
    public void moveZeroesTwo(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 以0为分割点交换
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                // 交换后后移
                nums[j++] = temp;
            }
        }

    }

    /**
     * 283. 移动零 一次遍历 -优化
     *
     * @param nums
     */
    public void moveZeroesThree(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }

    }

    /**
     * 11. 盛最多水的容器
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        // 定义左右指针
        int left = 0, right = height.length - 1;
        // 记录最大的面积
        int maxArea = 0;
        while (left < right) {
            // 记录当前面积 底*最小高度
            int currentArea = (right - left) * Math.min(height[left], height[right]);
            // 移动高度小的指针,保证可能有最大面积
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            // 比较记录最大面积
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;

    }

    /**
     * 15. 三数之和 排序+双指针
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            // 第一个如果是重复元素,则跳过
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            // 转化为两数之和
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                // 第二个如果是重复元素,则跳过
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 如果第二个数+第三个数大于,则右边移动,使和变小
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 如果相等了,退出循环
                if (second == third) {
                    break;
                }
                // 满足条件,获取三元组
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }

            }

        }
        return ans;

    }

    /**
     * 42. 接雨水 动态规划变形->双指针
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0;
        int leftMax = 0;// 左边最大值,随左指针移动而更新
        int right = height.length - 1;
        int rightMax = 0;// 右边最大值,随右指针移动而更新
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // 比较最大值,获取当前水滴,指针移动
            if (leftMax < rightMax) {
                ans += leftMax - height[left++];
            } else {
                ans += rightMax - height[right--];
            }

        }
        return ans;
    }

    /**
     * 3. 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for (int right = 0; right < charArray.length; right++) {
            char c = charArray[right];
            while (set.contains(c)) {
                set.remove(charArray[left]);
                left++;
            }
            set.add(c);
            ans = Math.max(ans, right - left + 1);

        }
        return ans;

    }

    /**
     * 3. 无重复字符的最长子串 核心 i-start+1
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwo(String s) {
        int[] last = new int[128]; // ASCII字符集的大小
        int start = 0; // 当前不含重复字符的子串的起始位置
        int result = 0; // 最长不含重复字符子串的长度

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i); // 当前字符的ASCII值
            // 更新当前字符的最后出现位置，窗口的起始位置
            start = Math.max(start, last[index]);
            // 计算当前窗口长度，并更新结果
            result = Math.max(result, i - start + 1);
            // 更新当前字符的最后出现位置
            last[index] = i + 1;
        }
        return result;

    }

    /**
     * 438. 找到字符串中所有字母异位词 暴力
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (pLen > sLen) {
            return ans;
        }
        char[] pCharArray = p.toCharArray();
        Arrays.sort(pCharArray);
        for (int i = 0; i + pLen <= sLen; i++) {
            String substring = s.substring(i, i + pLen);
            char[] sCharArray = substring.toCharArray();
            Arrays.sort(sCharArray);
            if (Arrays.equals(pCharArray, sCharArray)) {
                ans.add(i);
            }
        }

        return ans;
    }

    /**
     * 438. 找到字符串中所有字母异位词 滑动窗口+双指针
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagramsTwo(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        // 如果p的长度大于s的长度，则不可能存在异位词
        if (pLen > sLen) {
            return ans;
        }
        // 用于记录p和当前滑动窗口中字符的频率
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        // 初始化p的字符频率
        for (int i = 0; i < pLen; i++) {
            pCnt[p.charAt(i) - 'a']++;
        }
        int left = 0;
        // 遍历字符串s
        for (int right = 0; right < sLen; right++) {
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight]++;
            // 如果当前窗口中某字符的频率超过p中该字符的频率，移动左边界
            while (sCnt[curRight] > pCnt[curRight]) {
                int curLeft = s.charAt(left) - 'a';
                sCnt[curLeft]--;
                left++;
            }
            // 如果当前窗口的大小等于p的长度，则记录起始位置
            if (right - left + 1 == pLen) {
                ans.add(left);
            }
        }
        return ans;
    }

    /**
     * 560. 和为 K 的子数组 前缀和+哈希
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int pre = 0;// 前缀和
        int count = 0;// 计数器,记录满足条件的子数组数量
        Map<Integer, Integer> map = new HashMap<>();// 哈希表,存储前缀和出现的次数
        map.put(0, 1);// 初始化,前缀和为0的情况有1种
        // 遍历数组
        for (int num : nums) {
            pre += num;// 更新前缀和
            // 如果存在前缀和 pre - k，说明从某一位置到当前元素的和为k
            count += map.getOrDefault(pre - k, 0);
            // 更新哈希表中当前前缀和的出现次数
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        // 返回满足条件的子数组数量
        return count;
    }

    /**
     * 239. 滑动窗口最大值 优先队列处理
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            pq.offer(new int[] {nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[] {nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];

        }
        return ans;
    }

    /**
     * 239. 滑动窗口最大值 单调队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowTwo(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();// 双端队列,用于存储当前窗口的下标
        // 初始化窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];// 结果数组
        ans[0] = nums[deque.peekFirst()];// 第一个窗口的最大值
        // 处理接下来的窗口
        for (int i = k; i < n; i++) {
            // 移除队列中所有比当前元素小的元素
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);// 将当前元素的下标假如队列
            // 移除队列中不在当前窗口范围内的元素
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 当前窗口的最大值是队列的第一个元素
            ans[i - k + 1] = nums[deque.peekFirst()];
        }

        return ans;
    }

    /**
     * 76. 最小覆盖子串
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        // 如果 t 的长度大于 s 的长度，不可能存在这样的子串
        if (sLen < tLen) {
            return "";
        }
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        // 用于存储窗口内字符频率
        int[] cntWin = new int[128];
        // 用于存储 t 中字符频率
        int[] cntT = new int[128];
        // 初始化 t 中字符频率
        for (char c : charArrayT) {
            cntT[c]++;
        }
        // 当前窗口中满足 t 中字符频率的字符数量
        int distance = 0;
        // 最小窗口的长度
        int minLen = sLen + 1;
        // 最小窗口的起始位置
        int begin = 0;
        // 窗口的左右边界
        int left = 0, right = 0;
        while (right < sLen) {
            if (cntT[charArrayS[right]] == 0) {
                right++;
                continue;
            }
            if (cntWin[charArrayS[right]] < cntT[charArrayS[right]]) {
                distance++;
            }
            cntWin[charArrayS[right]]++;
            right++;

            // 当前窗口满足条件，记录窗口的起始位置和长度
            while (distance == tLen) {
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }
                // 缩小窗口
                if (cntT[charArrayS[left]] == 0) {
                    left++;
                    continue;
                }
                if (cntWin[charArrayS[left]] == cntT[charArrayS[left]]) {
                    distance--;
                }
                cntWin[charArrayS[left]]--;
                left++;
            }

        }
        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }

    /**
     * 53. 最大子序和 动态规划思想
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 初始化最大子数组和为数组的第一个元素
        int ans = nums[0];
        // 初始化当前子数组和为0
        int sum = 0;

        // 遍历数组中的每个元素
        for (int num : nums) {
            // 如果当前子数组和为正，则继续累加当前元素
            // 如果当前子数组和为负，则从当前元素重新开始计算子数组和
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            // 更新最大子数组和
            ans = Math.max(ans, sum);
        }
        return ans;

    }

    /**
     * 56. 合并区间
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 将区间起始位置对区间进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        // 初始化当前区间为第一个区间
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的结束位置大于等于下一个区间的起始位置,合并区间
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                // 否则将当前区间加入结果列表,并更新当前区间为下一个区间
                res.add(cur);
                cur = intervals[i];
            }

        }
        // 将最后一个区间加入结果列表
        res.add(cur);
        // 将结果列表转换为二维数组返回
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 189. 轮转数组
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        // 反转整个数组
        reverse(nums, 0, length - 1);
        // 翻转前k个元素
        reverse(nums, 0, k - 1);
        // 翻转后 n -k 个元素
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 238. 除自身以外数组的乘积 前缀积*后缀积
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre = 1; // 前缀乘积初始化为1
        int suf = 1; // 后缀乘积初始化为1
        int[] ans = new int[n]; // 用于存储结果的数组

        // 第一次遍历：计算前缀乘积
        for (int i = 0; i < n; i++) {
            ans[i] = pre; // 将当前前缀乘积赋值给结果数组
            pre *= nums[i]; // 更新前缀乘积
        }

        // 第二次遍历：计算后缀乘积
        for (int j = n - 1; j >= 0; j--) {
            ans[j] *= suf; // 将当前后缀乘积与结果数组中的值相乘
            suf *= nums[j]; // 更新后缀乘积
        }

        return ans; // 返回结果数组
    }

    /**
     * 41. 缺失的第一个正数 哈希表
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        int size = set.size();
        for (int i = 1; i <= size; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return size + 1;
    }

    /**
     * 41. 缺失的第一个正数 数组替换哈希
     *
     * @param nums
     * @return
     */
    public int firstMissingPositiveTwo(int[] nums) {
        int n = nums.length;

        // 第一步：将所有非正数和大于 n 的数替换为 n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // 第二步：将出现的数字对应的索引位置的值变为负数，标记存在性
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // 第三步：查找第一个正数对应的索引，即为缺失的第一个正整数
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // 如果所有位置都被标记，则返回 n+1
        return n + 1;
    }

    /**
     * 73. 矩阵置零
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    /**
     * 54. 螺旋矩阵 边界模拟
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        // 初始化左右上下边界值
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        List<Integer> ans = new ArrayList<>();
        while (true) {
            // 向右
            for (int i = l; i <= r; i++) {
                ans.add(matrix[t][i]);
            }
            // 重新设置上边界,判断
            if (++t > b) {
                break;
            }
            // 向下
            for (int i = t; i <= b; i++) {
                ans.add(matrix[i][r]);
            }
            // 重新设置右边界,判断
            if (l > --r) {
                break;
            }
            // 向左
            for (int i = r; i >= l; i--) {
                ans.add(matrix[b][i]);
            }
            // 重新设置下边界,判断
            if (t > --b) {
                break;
            }
            // 向上
            for (int i = b; i >= t; i--) {
                ans.add(matrix[i][l]);

            }
            // 重新设置左边界,判断
            if (++l > r) {
                break;
            }

        }
        return ans;
    }

    /**
     * 对称+转置
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 上下对称
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = temp;

            }

        }
        // 转置
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    /**
     * 240. 搜索二维矩阵 II,暴力
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == target) {
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * 240. 搜索二维矩阵 II,二分
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixTwo(int[][] matrix, int target) {
        // 右上角为起点
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        do {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        } while (i < m && j >= 0);

        return false;

    }

    /**
     * 160. 相交链表
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;

        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            // 当一条链走完,将从另一条链头继续移动,存在交点,总会相交
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * 206. 反转链表 迭代方法 1 -> 2 -> 3 -> 4 -> null null <- 1 <- 2 <- 3 <- 4
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }

    /**
     * 234. 回文链表
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalfStart = reverseList(slow);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        slow = reverseList(secondHalfStart);

        return result;

    }

    /**
     * 141. 环形链表 哈希表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;

    }

    /**
     * 141. 环形链表 双指针
     *
     * @param head
     * @return
     */
    public boolean hasCycleTwo(ListNode head) {
        // if (head == null || head.next == null) {
        // return false;
        // }
        //
        ListNode fast = head;
        ListNode slow = head;
        //
        // do {
        // if (fast.next == null || fast.next.next == null) {
        // return false;
        // }
        // slow = slow.next;
        // fast = fast.next.next;
        // } while (slow != fast);
        // return true;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;

    }

    /**
     * 142. 环形链表 II
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            // 相遇,有环
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;

            }
        }
        return null;
    }

    /**
     * 21. 合并两个有序链表 递归
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    /**
     * 21. 合并两个有序链表 非递归
     *
     * @param list1
     * @param list2
     * @return
     */
    private ListNode mergeTwoListsTwo(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;

        while (list1 != null || list2 != null) {
            // 得到节点值,节点为null,设置为最大值,保证小的排在前面
            int val1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            int val2 = list2 == null ? Integer.MAX_VALUE : list2.val;
            if (val1 < val2) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        return dummy.next;
    }

    /**
     * 2. 两数相加 输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807.
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        // 进位
        int carry = 0;
        // 循环直到两个链表都遍历完，且没有进位
        while (l1 != null || l2 != null || carry != 0) {
            // 获取当前结点的值，如果结点为空则值为0
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + carry;
            // 创建新结点存储当前位的和
            cur = cur.next = new ListNode(sum % 10);
            // 更新进位
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        return dummy.next;
    }

    /**
     * 19. 删除链表的倒数第 N 个结点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode right = dummy;
        ListNode left = dummy;
        while (n-- > 0) {
            right = right.next;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;

        return dummy.next;
    }

    /**
     * 24. 两两交换链表中的节点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        // 如果链表为空或只有一个节点，不需要交换，直接返回头节点
        if (head == null || head.next == null) {
            return head;
        }

        // 标记新的头节点，即当前头节点的下一个节点
        ListNode new_head = head.next;
        // 递归调用swapPairs处理剩余的链表，并将返回值连接到当前头节点的下一个节点
        head.next = swapPairs(new_head.next);
        // 将当前节点连接到新头节点的下一个节点
        new_head.next = head;

        // 返回新的头节点
        return new_head;

    }

    /**
     * 25. K 个一组翻转链表
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null, cur = head;
        for (; n >= k; n -= k) {
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;

    }

    /**
     * 138. 随机链表的复制
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node p = head, q = dummy;
        // 通过哈希表建立老新节点的映射关系
        Map<Node, Node> map = new HashMap<>();
        while (p != null) {
            // 创建新节点
            q.next = new Node(p.val);
            q = q.next;
            map.put(p, q);
            p = p.next;
        }
        p = head;
        q = dummy.next;
        while (p != null) {
            if (p.random != null) {
                // 设置新节点random值
                q.random = map.get(p.random);
            }
            p = p.next;
            q = q.next;
        }
        return dummy.next;

    }

    /**
     * 148. 排序链表
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    /**
     * 链表归并排序
     *
     * @param head
     * @return
     */
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode rightSorted = mergeSort(mid.next);
        mid.next = null;
        ListNode leftSorted = mergeSort(head);
        return mergeTwoListsTwo(leftSorted, rightSorted);
    }

    /**
     * 获取中间结点 偶数获取中间靠左
     *
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 23. 合并 K 个升序链表
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        // 使用优先队列,最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            cur.next = nextNode;
            cur = cur.next;
            // 当前节点有下一个节点则放入队列中
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummy.next;
    }

    /**
     * 94. 二叉树的中序遍历
     *中序遍历顺序: 左-中-右 入栈顺序： 左-右
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }

        return ans;

    }

    /**
     * 前序
     * 前序遍历顺序：中-左-右，入栈顺序：中-右-左
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return ans;

    }

    /**
     * 后序  后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(ans);

        return ans;

    }

    /**
     * 104. 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    /**
     * 226. 翻转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;

    }

    /**
     * 101. 对称二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSame(p.left, q.right) && isSame(p.right, q.left);
    }

    /**
     * 543. 二叉树的直径
     * 
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int ans;

    private int dfs(TreeNode node) {
        // 终止条件
        if (node == null) {
            return -1;
        }
        int lLen = dfs(node.left) + 1;
        int rLen = dfs(node.right) + 1;
        ans = Math.max(ans, lLen + rLen);
        return Math.max(lLen, rLen);
    }

    /**
     * 102. 二叉树的层序遍历
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> cur = List.of(root);
        while (!cur.isEmpty()) {
            List<TreeNode> nxt = new ArrayList<>();
            List<Integer> vals = new ArrayList<>(cur.size());
            for (TreeNode node : cur) {
                vals.add(node.val);
                if (node.left != null) {
                    nxt.add(node.left);
                }
                if (node.right != null) {
                    nxt.add(node.right);
                }
            }
            cur = nxt;
            ans.add(vals);
        }

        return ans;

    }

    /**
     * 102. 二叉树的层序遍历 -队列
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderTwo(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> vals = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode node = q.poll();
                vals.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(vals);
        }
        return ans;

    }

    /**
     * 108. 将有序数组转换为二叉搜索树 BST
     * 
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        return arrayToBSTHelper(nums, 0, nums.length - 1);

    }

    private TreeNode arrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBSTHelper(nums, left, mid - 1);
        root.right = arrayToBSTHelper(nums, mid + 1, right);

        return root;

    }

    /**
     * 98. 验证二叉搜索树
     * 
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        long x = node.val;
        return left < x && x < right && isValidBST(node.left, left, x) && isValidBST(node.right, x, right);
    }

    /**
     * 230. 二叉搜索树中第K小的元素
     * 
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    /**
     * 199. 二叉树的右视图
     * 
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode node, int depth, List<Integer> ans) {
        if (node == null) {
            return;
        }
        if (depth == ans.size()) {
            ans.add(node.val);
        }
        dfs(node.right, depth + 1, ans);
        dfs(node.left, depth + 1, ans);
    }

    /**
     * 114. 二叉树展开为链表
     * 
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }

    }

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int inorder_left, int inorder_right) {

        if (inorder_left > inorder_right) {
            return null;
        }
        int rooVal = preorder[rootIndex++];
        TreeNode root = new TreeNode(rooVal);
        root.left = buildTree(preorder, inorder_left, map.get(rooVal) - 1);
        root.right = buildTree(preorder, map.get(rooVal) + 1, inorder_right);
        return root;

    }

    private int rootIndex;
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * 437. 路径总和 III
     * 
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        prefixMap = new HashMap<>();
        target = targetSum;
        prefixMap.put(0L, 1);
        dfs(root, root.val);
        return res;

    }

    private void dfs(TreeNode node, long curSum) {
        if (prefixMap.containsKey(curSum - target)) {
            res += prefixMap.get(curSum - target);
        }
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);
        if (node.left != null) {
            dfs(node.left, curSum + node.left.val);
        }
        if (node.right != null) {
            dfs(node.right, curSum + node.right.val);
        }
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) - 1);
    }

    private Map<Long, Integer> prefixMap;
    private int target, res;

    /**
     * 236. 二叉树的最近公共祖先
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            // 只要当前根节点是p和q中的任意一个，就返回（因为不能比这个更深了，再深p和q中的一个就没了）
            return root;
        }
        // 根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // p和q都没找到，那就没有
        if (left == null && right == null) {
            return null;
        }
        // 左子树没有p也没有q，就返回右子树的结果
        if (left == null) {
            return right;
        }
        // 右子树没有p也没有q就返回左子树的结果
        if (right == null) {
            return left;
        }
        // 左右子树都找到p和q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
        return root;
    }

    /**
     * 124. 二叉树中的最大路径和
     * 
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        dsf_maxPathSum(root);
        return maxSum;

    }

    private int dsf_maxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lVal = dsf_maxPathSum(node.left);// 左子树最大链和
        int rVal = dsf_maxPathSum(node.right);// 右子树最大链和
        maxSum = Math.max(maxSum, lVal + rVal + node.val);
        return Math.max(Math.max(lVal, rVal) + node.val, 0);// 当前子树最大链和
    }

    private int maxSum = Integer.MIN_VALUE;

    /**
     * 200. 岛屿数量
     * 
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }

            }
        }
        return count;

    }

    private void dfs(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return;
        }
        if (grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '2';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    private boolean inArea(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[r].length;
    }

    /**
     * 994. 腐烂的橘子
     * 
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        Deque<int[]> deque = new LinkedList<>();
        int count = 0;// 新鲜橘子个数
        // 获取所有腐烂的橘子
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    deque.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        int round = 0;// 腐烂的轮数或分钟数
        while (count > 0 && !deque.isEmpty()) {
            round++;
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                int[] orange = deque.poll();
                int r = orange[0];
                int c = orange[1];
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    count--;
                    deque.add(new int[] {r - 1, c});
                }
                if (r + 1 < M && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    count--;
                    deque.add(new int[] {r + 1, c});
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    count--;
                    deque.add(new int[] {r, c - 1});
                }
                if (c + 1 < N && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    count--;
                    deque.add(new int[] {r, c + 1});
                }

            }
        }
        if (count > 0) {
            return -1;
        } else {
            return round;
        }

    }

    /**
     * 207. 课程表
     * 
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];// 入度数组
        // 定义map数组，key课程号，value：依赖key的课程号，比如key为1，依赖的value为3，4
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            map.putIfAbsent(prerequisite[1], new ArrayList<>());
            // 在对应被依赖课程key处添加依赖key的课程
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        Deque<Integer> deque = new LinkedList<>();// 将入度为0的放进来
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            // 弹出已选课程，在map找到依赖它的课程，在入度数组--
            Integer course = deque.poll();
            numCourses--;
            for (Integer nextCourse : map.getOrDefault(course, new ArrayList<>())) {
                if (--inDegree[nextCourse] == 0) {
                    deque.add(nextCourse);
                }
            }
        }
        return numCourses == 0;

    }



}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 146. LRU 缓存
 */
class LRUCache {
    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {}

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;

    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
