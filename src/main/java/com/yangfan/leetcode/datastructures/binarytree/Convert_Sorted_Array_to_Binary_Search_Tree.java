package com.yangfan.leetcode.datastructures.binarytree;

import com.yangfan.dataobject.TreeNode;

import java.util.Random;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * 将有序数组转换为二叉搜索树
 *
 * 给你一个整数数组 nums,
 * 其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 树化的过程，结果不唯一
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree {

    Random rand = new Random();

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            // 递归终止条件
            return null;
        }
        // 选择中间位置的元素作为根节点
//        int mid = left + (right - left) / 2;
        int mid = (left + right + rand.nextInt(2)) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        // 递归构造左子树
        node.left = buildBST(nums, left, mid - 1);
        // 递归构造右子树
        node.right = buildBST(nums, mid + 1, right);
        return node;
    }

}
