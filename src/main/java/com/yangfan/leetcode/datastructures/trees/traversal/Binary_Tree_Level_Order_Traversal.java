package com.yangfan.leetcode.datastructures.trees.traversal;


import com.yangfan.dataobject.TreeNode;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 * Given the root of a binary tree,
 * return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * 二叉树的层序遍历并返回
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * BFS好理解，看看DFS的实现
 */
public class Binary_Tree_Level_Order_Traversal {

    /**
     * gpt4给出的改进
     *
     * 1. 移除nodeLvMap：你可以直接在每一层的遍历开始时获取当前队列的大小，
     * 这个大小即为该层的节点数，这样就不需要额外的映射来跟踪每个节点的层级。
     *
     * 2. 最后一层处理：
     *   在循环的末尾检查cur.left == null && cur.right == null && queue.isEmpty()是不必要的，
     *   因为循环结束时，最后一层的节点已经被添加到currentLvNodes中，
     *   可以在循环结束后直接将其添加到result中。
     *
     * 下面是改进后的代码示例：
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
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
                // 遍历只会弹出前levelSize个元素，新添加的left或者right不会在此轮被弹出
                if (cur.left != null) helper.offer(cur.left);
                if (cur.right != null) helper.offer(cur.right);
            }
            result.add(currentLvData);
        }
        return result;
    }

    /**
     * 只是逐个遍历还好说，不需要关心层数概念
     */
    public static void BFS(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>(); // 所以linkedList是个queue
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val +" ");
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
        System.out.println();
    }

    /**
     * 通过DFS的方式实现层序遍历结果的输出(但实际上执行过程就不是层序遍历)
     */
    public List<List<Integer>> levelOrderByDFS(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        dfs(root, 0, levels);
        return levels;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> levels) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>()); // 如果当前层级的列表还不存在，创建一个新的列表
        }
        // 将当前节点的值加入到对应层的列表中
        levels.get(level).add(node.val);
        // 处理左子树
        if (node.left != null) {
            dfs(node.left, level + 1, levels);
        }
        // 处理右子树
        if (node.right != null) {
            dfs(node.right, level + 1, levels);
        }
    }


    /**
     * 我实现的方法
     * 有点蠢。。
     * 记录每个节点当前的lv，对比正在遍历的lv
     */
    public static List<List<Integer>> my(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curLevel = 1;
        Map<TreeNode, Integer> nodeLvMap = new HashMap<>();
        nodeLvMap.put(root, 1);
        List<Integer> currentLvNodes = new ArrayList<>();
        while(!queue.isEmpty()) {
            // 需要知道遍历到了第几层
            TreeNode cur = queue.poll();
            int nodeLv = nodeLvMap.get(cur);
            // 遍历到了下一层
            if(nodeLv != curLevel) {
                curLevel++;
                result.add(currentLvNodes); // 追加上一层所有非空节点
                currentLvNodes = new ArrayList<>();
                currentLvNodes.add(cur.val);
            } else {
                currentLvNodes.add(cur.val);  // 相同层就追加
            }
            // 执行到了最后一行最后一个元素
            if(cur.left == null && cur.right == null && queue.isEmpty()) {
                result.add(currentLvNodes);
            }
            if(cur.left != null) {
                queue.add(cur.left);
                nodeLvMap.put(cur.left, curLevel + 1);
            }
            if(cur.right != null) {
                queue.add(cur.right);
                nodeLvMap.put(cur.right, curLevel + 1);
            }
        }
        return result;
    }





}
