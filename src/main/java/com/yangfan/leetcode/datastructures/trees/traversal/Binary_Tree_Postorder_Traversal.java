package com.yangfan.leetcode.datastructures.trees.traversal;

import com.yangfan.dataobject.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 * Given the root of a binary tree,
 * return the postorder traversal of its nodes' values.
 *
 * 二叉树的后序遍历
 * 左右中
 *
 * 你猜猜为啥紧挨着 前序遍历 的是 后序遍历
 * 而不是 中序遍历
 */
public class Binary_Tree_Postorder_Traversal {


    /**
     * 非递归实现
     * 后序遍历: 左右中
     * 后序':    中左右
     *
     * 观察后序遍历与前序遍历的联系
     *
     */
    public List<Integer> postorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> loadStack = new Stack<>();
        Stack<TreeNode> printStack = new Stack<>();
        loadStack.push(root);
        while(!loadStack.isEmpty()) {
            TreeNode cur = loadStack.pop();
            printStack.push(cur);
            if(cur.left != null) {
                loadStack.push(cur.left);
            }
            if(cur.right != null) {
                loadStack.push(cur.right);
            }
        }

        while(!printStack.isEmpty()) {
            result.add(printStack.pop().val);
        }
        return result;
    }

    /**
     * 递归方式
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(result, root);
        return result;
    }

    /**
     * 传统的后序遍历递归写法
     */
    public void postOrder(List<Integer> data, TreeNode root) {
        if(root == null) return;
        postOrder(data, root.left);
        postOrder(data, root.right);
        data.add(root.val);
    }


}
