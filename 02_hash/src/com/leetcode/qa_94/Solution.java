package com.leetcode.qa_94;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @author huangjian
 */
public class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (null != root.left) {
            inorder(root.left);
        }
        res.add(root.val);
        if (null != root.right) {
            inorder(root.right);
        }
        if (null == root.left && null == root.right) {
            return;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        List<Integer> res = solution.inorderTraversal(node1);
        System.out.println(res);
    }
}
