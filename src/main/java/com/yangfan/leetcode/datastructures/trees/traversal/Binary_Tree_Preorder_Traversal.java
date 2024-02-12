package com.yangfan.leetcode.datastructures.trees.traversal;

import com.yangfan.dataobject.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
//        // 也可以这样写
//        dfs(result, root);
        return result;
    }

    /**
     * 传统的前序遍历递归写法
     */
    void pre(List<Integer> data, TreeNode root) {
        if(root == null) return;
        data.add(root.val);
        pre(data, root.left);
        pre(data, root.right);
    }

    /**
     * 另一种递归写法
     * （其实没必要，只是为了加深理解）
     */
    void dfs(List<Integer> data, TreeNode root) {
        if(root == null) return;
        data.add(root.val);
        if(root.left != null) {
            dfs(data, root.left);
        }
        if(root.right != null) {
            dfs(data, root.right);
        }
    }

    /**
     * 前序遍历: 中左右
     * 前序' :  中右左   这个是迭代序
     */
    public List<Integer> preOrderIterative(TreeNode root) {
        System.out.println("pre-order:");
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
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
