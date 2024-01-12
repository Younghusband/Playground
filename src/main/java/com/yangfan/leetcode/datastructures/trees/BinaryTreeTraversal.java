package com.yangfan.leetcode.datastructures.trees;

import com.yangfan.dataobject.TreeNode;

import java.util.Stack;

/**
 *  画一个二叉树
 *
 *  二叉树的遍历
 *  前序遍历: 中左右
 *  中序遍历: 左中右
 *  后序遍历: 左右中
 *
 *  前中后序遍历与递归序的关系:
 *  二叉树的递归序是指在递归遍历过程中，每个节点都可能被经过三次：
 *  首次到达该节点、从左子树返回后到达该节点、从右子树返回后到达该节点。前序、中序、后序遍历都是递归序的子集。
 *
 * 前序遍历：在第一次到达节点时访问。
 * 中序遍历：在从左子树返回后，也就是第二次到达节点时访问。
 * 后序遍历：在从右子树返回后，即第三次到达节点时访问。
 *      1
 *     / \
 *    2   3
 *   / \
 *  4   5
 *
 * 递归序：1(首次) 2(首次) 4(首次) 4(第二次) 4(第三次)
 * 2(第二次) 5(首次) 5(第二次) 5(第三次) 2(第三次) 1(第二次)
 * 3(首次) 3(第二次) 3(第三次) 1(第三次)
 * 前序遍历：1 2 4 5 3
 * 中序遍历：4 2 5 1 3
 * 后序遍历：4 5 2 3 1
 *
 * 如何用非递归的方式实现二叉树的遍历？
 *
 *
 */
public class BinaryTreeTraversal {

    public static void main(String[] args) {



    }

    /**
     * 先是递归方式实现
     * 前中后序遍历
     */
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    /**
     * 非递归方式实现的前中后序遍历
     * ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
     * 右侧为迭代序
     * 前序: 中左右  |  中右左
     * 中序: 左中右  |  左右中
     * 后序: 左右中  |  中左右
     * 把这三个迭代序列记住，就可以很容易的写出非递归的遍历方式
     * 把这三个汉字看做一个环
     */


    /**
     * 前序遍历: 中左右
     * 前序' :  中右左   这个是迭代序
     */
    public void preOrderIterative(TreeNode root) {
        System.out.println("pre-order:");
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if(node.right != null) {
                stack.push(node.right); // 先右后左，保证左子树先处理
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 后序遍历: 左右中
     * 后序':    中左右
     *
     * 观察后序遍历与前序遍历的联系
     *
     */
    public void postOrderIterative(TreeNode root) {
        System.out.println("post-order:");
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> helper = new Stack<>(); // 用于存储后序遍历的逆序
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            helper.push(node);
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        while(!helper.isEmpty()) {
            System.out.print(helper.pop().val + " ");
        }
    }

    /**
     * 中序遍历: 左中右
     *
     */
    public void inOrderIterative(TreeNode root) {
        System.out.println("in-order:");
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val + " ");
                root = root.right;
            }
        }
    }




}
