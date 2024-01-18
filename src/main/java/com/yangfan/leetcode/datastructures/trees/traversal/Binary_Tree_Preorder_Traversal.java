package com.yangfan.leetcode.datastructures.trees.traversal;

import com.yangfan.dataobject.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Given the root of a binary tree,
 * return the preorder traversal of its nodes' values.
 *
 * 二叉树的前序遍历
 * 中左右
 *
 * 递归序的每个元素第一次出现的顺序
 *
 * 常用于:
 *
 */
public class Binary_Tree_Preorder_Traversal {

    /**
     * 递归写法
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        pre(result, root);
        return result;
    }

    void pre(List<Integer> list, TreeNode root) {
        if(root == null) return;
        list.add(root.val);
        pre(list, root.left);
        pre(list, root.right);
    }

    /**
     * 前序遍历: 中左右
     * 前序' :  中右左   这个是迭代序
     */
    public List<Integer> preOrderIterative(TreeNode root) {
        System.out.println("pre-order:");
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if(cur.right != null) {
                stack.push(cur.right); // 先右后左，保证左子树先处理
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }





}
