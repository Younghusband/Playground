package com.yangfan.leetcode.datastructures.trees.traversal;

import com.yangfan.dataobject.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * 二叉树的中序遍历
 *
 * Given the root of a binary tree,
 * return the inorder traversal of its nodes' values.
 *
 * 最为广泛应用的二叉树遍历，尤其是对于二叉搜索树而言
 *
 * 延伸: Morris遍历算法  空间复杂度O(1), 仅需要一个临时节点即可
 */
public class Binary_Tree_Inorder_Traversal {


    /**
     * 非递归实现
     *
     * 思路就是，不断的遍历到最左侧节点后向右一个节点，然后继续遍历它的左侧
     * 直至完成。
     *
     */
    public List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 遍历到最左下节点后，向右
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }


    /**
     * Morris TODO
     */
    public List<Integer> morris(TreeNode root) {

        return null;
    }


    /**
     * 递归实现
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(result, root);
        return result;
    }

    public void inorder(List<Integer> data, TreeNode root) {
        if(root == null) return;
        inorder(data, root.left);
        data.add(root.val);
        inorder(data, root.right);
    }

    /**
     * 递归另一种写法
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        res.addAll(inorderTraversal1(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal1(root.right));
        return res;
    }


}
