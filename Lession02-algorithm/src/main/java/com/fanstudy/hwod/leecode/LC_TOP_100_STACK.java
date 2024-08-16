package com.fanstudy.hwod.leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 */
public class LC_TOP_100_STACK {

    /**
     * 20. 有效的括号
     */
    class LC_20 {
        public boolean isValid(String s) {

            char[] charArray = s.toCharArray();
            Deque<Character> stack = new LinkedList<>();
            for (char c : charArray) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                }
                if (c == ')') {
                    if (!stack.isEmpty()) {
                        Character peek = stack.peek();
                        if (peek.equals('(')) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }

                }
                if (c == ']') {
                    if (!stack.isEmpty()) {
                        Character peek = stack.peek();
                        if (peek.equals('[')) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }

                }
                if (c == '}') {
                    if (!stack.isEmpty()) {
                        Character peek = stack.peek();
                        if (peek.equals('{')) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }

                }
            }

            return stack.isEmpty();

        }
    }

    /**
     * 155. 最小栈
     */
    class MinStack {

        private Node dummy;

        private class Node {
            int val, min;
            Node prev, next;

            public Node(int val, int min, Node prev, Node next) {
                this.val = val;
                this.min = min;
                this.prev = prev;
                this.next = next;
            }
        }

        public MinStack() {
            dummy = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE, null, null);
            dummy.next = dummy;
            dummy.prev = dummy;
        }

        public void push(int val) {
            Node tempNode = new Node(val, val, null, null);
            tempNode.min = Math.min(dummy.next.min, val);
            tempNode.prev = dummy;
            tempNode.next = dummy.next;
            tempNode.prev.next = tempNode;
            tempNode.next.prev = tempNode;

        }

        public void pop() {
            dummy.next = dummy.next.next;
            dummy.next.prev = dummy;
        }

        public int top() {
            return dummy.next.val;

        }

        public int getMin() {
            return dummy.next.min;
        }
    }

    /**
     * 394. 字符串解码
     */
    class LC_394 {
        public String decodeString(String s) {
            StringBuilder ans = new StringBuilder();
            int multi = 0;
            Deque<Integer> stack_multi = new LinkedList<>();
            Deque<String> stack_str = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '[') {
                    stack_multi.push(multi);
                    stack_str.push(ans.toString());
                    multi = 0;
                    ans = new StringBuilder();

                } else if (c == ']') {
                    StringBuilder temp = new StringBuilder();
                    int cur_multi = stack_multi.pop();
                    for (int i = 0; i < cur_multi; i++) {
                        temp.append(ans);

                    }
                    ans = new StringBuilder(stack_str.pop() + temp);

                } else if (c >= '0' && c <= '9') {
                    multi = multi * 10 + Integer.parseInt(String.valueOf(c));

                } else {
                    ans.append(c);
                }
            }

            return ans.toString();

        }
    }

    /**
     * 739. 每日温度
     */
    class LC_739 {

        public int[] dailyTemperaturesOne(int[] temperatures) {
            int[] ans = new int[temperatures.length];
            int left = 0;
            while (left < temperatures.length) {
                int right = left;
                while (true) {
                    if (temperatures[right] > temperatures[left]) {
                        break;
                    }
                    if (right == temperatures.length - 1) {
                        right = left;
                        break;
                    }
                    right++;
                }
                ans[left] = right - left;
                left++;
            }

            return ans;

        }

        /**
         * 单调栈
         * 
         * @param temperatures
         * @return
         */
        public int[] dailyTemperatures(int[] temperatures) {
            int length = temperatures.length;
            int[] ans = new int[length];
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                int temperature = temperatures[i];
                while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                    Integer preIndex = stack.pop();
                    ans[preIndex] = i - preIndex;
                }
                stack.push(i);

            }
            return ans;

        }
    }

    /**
     * 84. 柱状图中最大的矩形
     */
    class LC_84 {

        // 暴力
        public int largestRectangleAreaOne(int[] heights) {
            int length = heights.length;
            if (length == 0) {
                return 0;
            }
            int ans = 0;
            for (int i = 0; i < length; i++) {

                int curHeight = heights[i];
                int left = i;
                int right = i;
                while (left > 0 && heights[left - 1] >= curHeight) {
                    left--;
                }
                while (right < length - 1 && heights[right + 1] >= curHeight) {
                    right++;
                }
                int with = right - left + 1;

                ans = Math.max(ans, with * curHeight);

            }
            return ans;

        }

        /**
         * 栈
         * 
         * @param heights
         * @return
         */
        public int largestRectangleArea(int[] heights) {
            int length = heights.length;
            if (length == 0) {
                return 0;
            }
            if (length == 1) {
                return heights[0];
            }
            int ans = 0;

            int[] newHeights = new int[length + 2];
            newHeights[0] = 0;
            System.arraycopy(heights, 0, newHeights, 1, length);
            newHeights[length + 1] = 0;
            length += 2;
            heights = newHeights;
            Deque<Integer> stack = new LinkedList<>();
            stack.push(0);

            for (int i = 1; i < length; i++) {
                while (heights[i] < heights[stack.peek()]) {
                    int curHeight = heights[stack.pop()];
                    int curWidth = i - stack.peek() - 1;
                    ans = Math.max(ans, curWidth * curHeight);
                }
                stack.push(i);
            }

            return ans;

        }

    }

}
