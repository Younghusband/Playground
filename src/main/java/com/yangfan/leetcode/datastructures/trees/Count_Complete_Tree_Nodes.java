package com.yangfan.leetcode.datastructures.trees;

import com.yangfan.dataobject.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 222. Count Complete Tree Nodes
 *
 * Given the root of a complete binary tree,
 * return the number of the nodes in the tree.
 *
 * 比较简单，就是层序遍历，最后一层的节点数加上上面所有层的节点数
 * 根据层高计算上面所有层的节点数
 * 然后追加最后一层的节点数
 *
 */
public class Count_Complete_Tree_Nodes {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left= new TreeNode(6);

        System.out.println(new Count_Complete_Tree_Nodes().countNodes(tree));
    }


    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int height = 0;
        int lastLayerSize = 0;
        Queue<TreeNode> helper = new LinkedList<>();
        helper.add(root);
        while(!helper.isEmpty()) {
            lastLayerSize = helper.size();
            for(int i = 1; i <= lastLayerSize; i++) {
                TreeNode cur = helper.poll();
                if(cur.left != null) helper.add(cur.left);
                if(cur.right != null) helper.add(cur.right);
            }
            height++;
        }
        return (1 << (height - 1)) - 1 + lastLayerSize; // 位运算需要加括号，否则会先算减法
    }

    /**
     * 递归方式
     *
     * 但是这个是计算二叉树的节点数，并没有利用到完全二叉树的特性
     */
    public int count(TreeNode root) {
        if(root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }

}
