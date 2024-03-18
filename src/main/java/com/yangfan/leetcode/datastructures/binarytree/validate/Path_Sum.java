package com.yangfan.leetcode.datastructures.binarytree.validate;

import com.yangfan.dataobject.TreeNode;

/**
 * 112. Path Sum
 * 路径总和
 *
 * 典型的一鱼多吃基础题型，需背牢
 * 1. 递归DFS
 * 2. BFS
 */

public class Path_Sum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


}
