package com.yangfan.leetcode.datastructures.binarytree.traversal;

import com.yangfan.dataobject.TreeNode;

import java.util.*;

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
    public List<Integer> postorderIterative(TreeNode root) {
        LinkedList<Integer> result = new LinkedList();
        if(root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val); // 根会被挤到最后

            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
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
