package com.yangfan.leetcode.datastructures.binarytree.traversal;

import com.yangfan.dataobject.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * 二叉树的锯齿形层序遍历
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * 没什么特殊的，就根据层数决定list的正向or反向插入
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal {

    /**
     * BFS
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int layer = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layerData = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(layer % 2 == 0)
                    layerData.add(cur.val);
                else
                    layerData.add(0, cur.val); // 倒序插入
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            layer++;
            res.add(layerData);
        }
        return res;
    }

    /**
     * DFS实现
     */
    public List<List<Integer>> zigzagLevelOrderByDFS(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        dfs(root, 0, levels);
        return levels;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> levels) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>()); // 如果当前层级的列表还不存在，创建一个新的列表
        }
        // 根据层数奇偶决定数据插入顺序
        if(level % 2 == 0)
            levels.get(level).add(node.val);
        else
            levels.get(level).add(0, node.val);
        if (node.left != null) {
            dfs(node.left, level + 1, levels);
        }
        if (node.right != null) {
            dfs(node.right, level + 1, levels);
        }
    }


}
