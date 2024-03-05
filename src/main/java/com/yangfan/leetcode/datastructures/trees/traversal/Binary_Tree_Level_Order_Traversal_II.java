package com.yangfan.leetcode.datastructures.trees.traversal;


import com.yangfan.dataobject.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal II
 * 二叉树的层序遍历 II
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (i.e., from left to right, level by level from leaf to root).
 *
 * 二叉树的自底向上的层序遍历
 输入：root = [3,9,20,null,null,15,7]
 输出：[[15,7],[9,20],[3]]
 *
 * 和自顶向下的遍历仅一行代码的区别
 *
 */
public class Binary_Tree_Level_Order_Traversal_II {

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for(int i = 1; i < 11; i++) {
            data.add(0, i);
        }
        System.out.println(data);
    }

    /**
     * BFS
     * 核心: result.add(0, currentLvData);
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> helper = new LinkedList<>();
        helper.offer(root);
        while (!helper.isEmpty()) {
            int levelSize = helper.size();
            List<Integer> currentLvData = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = helper.poll();
                currentLvData.add(cur.val);
                if (cur.left != null) helper.offer(cur.left);
                if (cur.right != null) helper.offer(cur.right);
            }
            result.add(0, currentLvData); // 老值挤到后面去
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottomByDFS(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        dfs(root, 0, levels);
        return levels;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> levels) {
        int len = levels.size();
        if (len == level) {
            levels.add(0, new ArrayList<>()); // 如果当前层级的列表还不存在，在头部插入一个新列表
        }
        // 从尾往头数第k个
        levels.get(len - 1 - level).add(node.val);
        if (node.left != null) {
            dfs(node.left, level + 1, levels);
        }
        if (node.right != null) {
            dfs(node.right, level + 1, levels);
        }
    }

}
