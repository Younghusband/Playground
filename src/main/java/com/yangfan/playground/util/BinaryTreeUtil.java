package com.yangfan.playground.util;


import com.yangfan.dataobject.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树工具类
 */
public class BinaryTreeUtil {

    public static void main(String[] args) {

    }


    /**
     * 根据数组生成一颗二叉树，数组中的null表示空节点
     */
    public static TreeNode createBinaryTree(Integer[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (i < arr.length && arr[i] != null) {
                cur.left = new TreeNode(arr[i]);
                queue.add(cur.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                cur.right = new TreeNode(arr[i]);
                queue.add(cur.right);
            }
            i++;
        }
        return root;
    }


}
