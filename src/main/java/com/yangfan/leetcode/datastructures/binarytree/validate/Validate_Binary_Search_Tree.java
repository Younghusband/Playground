package com.yangfan.leetcode.datastructures.binarytree.validate;

import com.yangfan.dataobject.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 * 验证二叉搜索树
 * A valid BST is defined as follows:
 *
 * 1. The left subtree of a node contains only nodes with keys less than the node's key.
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 *
 * 注意数据范围:
 *  The number of nodes in the tree is in the range [1, 104].
 * -2^31 <= Node.val <= 2^31 - 1
 *
 * 二叉搜索树需要严格递增，前驱or后驱节点等于是不行的。
 */
public class Validate_Binary_Search_Tree {


    /**
     * Integer.MIN_VALUE踩在数据限制范围内
     * 直接减1则会越界，直接用long又太浪费
     */
    long preValue = (long)Integer.MIN_VALUE - 1; // 对比(long)(Integer.MIN_VALUE - 1) 这个则毫无效果

    /**
     * 1. 先检查左子树，左子树不符合直接return false
     * 2. 检查左子树最大(右)值 和 当前节点值大小，
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(root.val <= preValue)
            return false;
        preValue = root.val;
        return isValidBST(root.right);
    }

    /**
     * 我的改良版
     * 在中序遍历的非递归序里加入了比较
     *
     * 加深理解，非递归序的第一步找到的就是二叉树的最左端
     * 也就是二叉搜索树的最小值
     *
     */
    public boolean myPro(TreeNode root) {
        Stack<TreeNode> helper = new Stack<>();
        Integer lastVal = null; // 用于记录上一个节点的值
        while(root != null || !helper.isEmpty()) {
            if(root != null) {
                helper.push(root);
                root = root.left;
            } else {
                root = helper.pop();
                // 检查是否递增
                if(lastVal != null && root.val <= lastVal) {
                    return false;
                }
                lastVal = root.val;
                root = root.right;
            }
        }
        return true;
    }



    /**
     * 来个最蠢的方法抛砖引玉
     *
     * 1. 传统方式非递归二叉树中序遍历
     * 2. 将记录下来的数组遍历查看是否递增
     *
     * 蠢的点在于，
     * 是不是严格递增其实在添加过程中就已经可以判断和中断了
     *
     */
    public boolean my(TreeNode root) {
        List<Integer> data = new ArrayList();
        // 传统非递归中序遍历
        Stack<TreeNode> helper = new Stack();
        while(root != null || !helper.isEmpty()) {
            if(root != null) {
                helper.push(root);
                root = root.left;
            }
            else {
                root = helper.pop();
                data.add(root.val);
                root = root.right;
            }
        }
        return checkDizeng(data);
    }

    private boolean checkDizeng(List<Integer> data) {
        int size = data.size();
        if(size == 1) return true;
        for(int i = 0; i < size - 1; i++) {
            if(data.get(i) >= data.get(i+1))
                return false;
        }
        return true;
    }


}
