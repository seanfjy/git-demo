package com.fanstudy.hwod.truthques.CD100;

import java.util.Scanner;

/**
 * 计算三叉搜索树的高度
 *
 * tree 节点定义构造
 */
public class N_22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            tree.add(num);
        }
        System.out.println(tree.height);
    }

    static class TreeNode {
        int val;
        int height;
        TreeNode left;
        TreeNode mid;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class Tree {
        TreeNode root;
        int height;

        public void add(int val) {
            TreeNode node = new TreeNode(val);
            if (this.root == null) {
                node.height = 1;
                this.root = node;
                this.height = 1;
            } else {
                TreeNode cur = this.root;
                while (true) {
                    node.height = cur.height + 1;
                    this.height = Math.max(node.height, this.height);
                    if (val < cur.val - 500) {
                        if (cur.left == null) {
                            cur.left = node;
                            break;
                        } else {
                            cur = cur.left;
                        }
                    } else if (val > cur.val + 500) {
                        if (cur.right == null) {
                            cur.right = node;
                            break;
                        } else {
                            cur = cur.right;
                        }
                    } else {
                        if (cur.mid == null) {
                            cur.mid = node;
                            break;
                        } else {
                            cur = cur.mid;
                        }
                    }

                }

            }
        }
    }
}
