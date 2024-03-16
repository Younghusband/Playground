package com.yangfan.leetcode.datastructures.binarytree;

import com.yangfan.dataobject.TreeNode;

/**
 * 543. Diameter of Binary Tree
 * 二叉树的直径
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of
 * the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * 学到了:
 * 1. 全局变量保存DFS副产物
 * 2. 二叉树的直径 = 左子树最大深度 + 右子树最大深度
 * 3. 节点深度 = 左子树的最大深度 + 右子树的最大深度 + 1
 */
public class Diameter_of_Binary_Tree {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.left); // 左子树的最大深度
        int rightDepth = maxDepth(node.right); // 右子树的最大深度
        // 更新最大直径
        diameter = Math.max(diameter, leftDepth + rightDepth);
        // 返回节点的最大深度
        return Math.max(leftDepth, rightDepth) + 1;  // core
    }

}
