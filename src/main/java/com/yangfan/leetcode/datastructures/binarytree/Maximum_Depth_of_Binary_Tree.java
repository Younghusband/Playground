package com.yangfan.leetcode.datastructures.binarytree;


import com.yangfan.dataobject.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * 二叉树的最大深度
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 */
public class Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 也可以层序遍历，每一层depth++

}
