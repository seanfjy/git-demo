package com.fanstudy.hwod.truthques.CD100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 生成哈夫曼树  中序遍历  + 优先队列
 */
public class N_32 {

    static class TreeNode {

        TreeNode left;
        TreeNode right;

        int val;

        int height;

        public TreeNode(TreeNode left, TreeNode right, int val, int height) {
            this.left = left;
            this.right = right;
            this.val = val;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<TreeNode> pq =
            new PriorityQueue<>((n1, n2) -> n1.val != n2.val ? n1.val - n2.val : n1.height - n2.height);
        for (int i = 0; i < n; i++) {
            pq.offer(new TreeNode(null, null, in.nextInt(), 0));
        }
        while (pq.size() > 1) {
            TreeNode left = pq.poll();
            TreeNode right = pq.poll();
            int faVal = left.val + right.val;
            int faHeight = Math.max(left.height, right.height) + 1;
            TreeNode fa = new TreeNode(left, right, faVal, faHeight);
            pq.offer(fa);
        }
        TreeNode root = pq.poll();
        StringJoiner sj = new StringJoiner(" ");
        midOrder(root, sj);
        System.out.println(sj);
    }

    private static void midOrder(TreeNode root, StringJoiner sj) {
        if (root.left != null) {
            midOrder(root.left, sj);
        }
        sj.add(String.valueOf(root.val));
        if (root.right != null) {
            midOrder(root.right, sj);
        }

    }

    private static void midOrderTwo(TreeNode root, StringJoiner sj) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                sj.add(String.valueOf(cur.val));
                cur = cur.right;
            }
        }

    }
}
