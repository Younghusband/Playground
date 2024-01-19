package com.yangfan.leetcode.datastructures.trees;

import com.yangfan.dataobject.TreeNode;

/**
 * 226. Invert Binary Tree
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * 翻转二叉树
 * 没啥好讲的
 */
public class Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        // 翻转原左子树
        TreeNode newL = invertTree(root.left);
        // 翻转原右子树
        TreeNode newR = invertTree(root.right);
        root.left = newR;
        root.right = newL;
        return root;
    }

}
