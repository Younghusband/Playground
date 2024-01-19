package com.yangfan.leetcode.datastructures.trees.validate;

import com.yangfan.dataobject.TreeNode;

/**
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * 平衡二叉树: 左右子树高度差不超过1
 *
 */
public class Balanced_Binary_Tree {

    /**
     *  分别判断左右子树是否平衡
     *  然后在左右子树都平衡的情况下 再比较二者高度差
     */
    public boolean isBalanced(TreeNode root) {
        return check(root).isBalanced;
    }

    public ReturnType check(TreeNode root) {
        if(root == null) return new ReturnType(true, 0);
        ReturnType leftData = check(root.left);
        ReturnType rightData = check(root.right);

        int rootHeight = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, rootHeight);
    }

    class ReturnType {
        int height;
        boolean isBalanced;
        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }




}
