package com.fanstudy.hwod.truthques.CD200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 二叉树计算 前序,中序构建二叉树,根节点值有重复
 */
public class H_04 {

    static class TreeNode {
        int val;
        int childSum; // 当前节点的左子树+右子树的值
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.childSum = 0;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        inOrder = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        preOrder = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = inOrder.length;
        for (int i = 0; i < n; i++) {
            int val = inOrder[i];
            inOderIdxMap.putIfAbsent(val, new ArrayList<>());
            inOderIdxMap.get(val).add(i);
        }
        // 根据中序遍历和前序遍历还原树结构
        TreeNode root = buildTree(0, n - 1, 0, n - 1);
        StringJoiner sj = new StringJoiner(" ");
        getInOrder(root, sj);

        System.out.println(sj);
    }

    private static void getInOrder(TreeNode root, StringJoiner sj) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            getInOrder(root.left, sj);
        }
        sj.add(String.valueOf(root.childSum));
        if (root.right != null) {
            getInOrder(root.right, sj);
        }

    }

    /**
     *
     * @param in_left 中序左索引
     * @param in_right 中序右索引
     * @param pre_left 前序左索引
     * @param pre_right 前序右索引
     * @return 根节点
     */
    private static TreeNode buildTree(int in_left, int in_right, int pre_left, int pre_right) {

        if (pre_left > pre_right) {
            return null;
        }
        // 根据前序得到根节点
        int rootVal = preOrder[pre_left];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历序列中,找到对应的值位置
        for (int idx : inOderIdxMap.get(rootVal)) {
            // 越界,排除
            if (idx < in_left || idx > in_right) {
                continue;
            }
            // 如果中序的左子树和前序的左子树不同,则对应根值位置不对
            int leftLen = idx - in_left;
            if (notEqual(in_left, pre_left + 1, leftLen)) {
                continue;
            }
            int rightLen = in_right - idx;
            // 只验证左子树即可
//            if (notEqual(idx + 1, pre_right - rightLen + 1, rightLen))
//                continue;

            root.left = buildTree(in_left, idx - 1, pre_left + 1, pre_left + leftLen);
            root.right = buildTree(idx + 1, in_right, pre_right - rightLen + 1, pre_right);

            // 记录该节点:左子树+右子树 的和
            root.childSum = (root.left == null ? 0 : (root.left.val + root.left.childSum))
                + (root.right == null ? 0 : (root.right.val + root.right.childSum));

            break;
        }

        return root;

    }

    private static boolean notEqual(int inLeft, int preLeft, int length) {
        int[] arr1 = Arrays.stream(Arrays.copyOfRange(preOrder, preLeft, preLeft + length)).sorted().toArray();
        int[] arr2 = Arrays.stream(Arrays.copyOfRange(inOrder, inLeft, inLeft + length)).sorted().toArray();
        for (int i = 0; i < length; i++) {
            if (arr1[i] != arr2[i]) {
                return true;
            }

        }
        return false;
    }

    // 前序遍历序列
    static int[] preOrder;

    // 中序遍历序列
    static int[] inOrder;
    static Map<Integer, ArrayList<Integer>> inOderIdxMap = new HashMap<>();
}
