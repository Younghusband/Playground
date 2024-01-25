package com.yangfan.leetcode.datastructures.trees.traversal;


import com.yangfan.dataobject.TreeNode;

import java.util.*;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * 二叉树的最近公共祖先
 *
 * 这道题的力扣中文官方题解有问题，两个解法都不要看。
 *
 * 通过这道题，对前序遍历的理解加深了一点。
 */
public class Lowest_Common_Ancestor {

    /**
     * 经典标准解法
     * 不太容易理解
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    /**
     * 我的蠢b解法
     * 1. 先构建node -> node父节点 的map
     * 2. 从两个节点各自遍历map 利用set找相遇点
     */
    public TreeNode my(TreeNode root, TreeNode p, TreeNode q) {
        if(p == q) return p;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        // 1. 遍历树，塞入map
        dfs(parentMap, root);
        // 2. p和q分别通过这个map往上溯源，并用set记录
        Set<TreeNode> visited = new HashSet<>();
        while(p != null) {
            visited.add(p);
            p = parentMap.get(p);
        }
        while(q != null) {
            if(visited.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return null;
    }

    /**
     * 前序遍历递归变体
     */
    void dfs(Map<TreeNode, TreeNode> parentMap, TreeNode root) {
        if(root.left != null) {
            dfs(parentMap, root.left);
            parentMap.put(root.left, root);
        }
        if(root.right != null) {
            dfs(parentMap, root.right);
            parentMap.put(root.right, root);
        }
    }



}
