package com.yangfan.leetcode.datastructures.trees.validate;

import com.yangfan.dataobject.TreeNode;

/**
 * Leetcode没有这题
 * 判断二叉树是否是满二叉树
 *
 */
public class IsFullTree {

    public boolean isFull(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left != null && root.right != null)
            return isFull(root.left) && isFull(root.right);
        return false;
    }

    public boolean isFullTree(TreeNode root) {
        return true;
    }


}
