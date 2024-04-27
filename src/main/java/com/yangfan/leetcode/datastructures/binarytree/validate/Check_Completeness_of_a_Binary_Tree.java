package com.yangfan.leetcode.datastructures.binarytree.validate;

import com.yangfan.dataobject.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 958. Check Completeness of a Binary Tree
 *
 * Given the root of a binary tree, determine if it is a complete binary tree.
 *
 * 如果遇到了空节点，后面不能再有非空节点
 */
public class Check_Completeness_of_a_Binary_Tree {

    /**
     * 核心是，不判断左右节点是否为空都放到队列中
     *
     * 注意先判断节点非空，再判断是否遇到过空，这样代码结构好一些。
     */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 标记是否遇到了空节点。
        // 两种情况，1. 遇到上层的空节点，2. 本层的空节点
        boolean reachedEnd = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 如果遇到了空节点
            if (node == null) {
                reachedEnd = true;
            } else {
                // 如果之前已经遇到了空节点，再遇到非空节点，就不是完全二叉树
                if (reachedEnd) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }


}
