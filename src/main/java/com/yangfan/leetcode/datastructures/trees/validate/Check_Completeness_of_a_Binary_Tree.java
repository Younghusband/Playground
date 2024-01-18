package com.yangfan.leetcode.datastructures.trees.validate;

import com.yangfan.dataobject.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 958. Check Completeness of a Binary Tree
 *
 * Given the root of a binary tree, determine if it is a complete binary tree.
 *
 * 需要注意的是
 * 1. 有右无左必不是
 * 2. 如果当前节点的左右子树不全(有左无右 || 左右皆无)，必然该层节点是叶子节点
 */
public class Check_Completeness_of_a_Binary_Tree {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean notComplete = false;
        TreeNode l;
        TreeNode r;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            l = cur.left;
            r = cur.right;

            // 上一层最右侧不完整，但是这一层依旧还有子节点
            if(notComplete && (l != null || r != null)) {
                return false;
            }

            // 左子节点为空， 右子节点不为空
            if(l == null && r != null) {
                return false;
            }

            // 简化为下面的
            // if((l == null && r == null) || (l != null && r == null)) {
            //     notComplete = true;
            // }

            if(r == null) {
                notComplete = true;
            }

            if(l != null) queue.add(l);
            if(r != null) queue.add(r);
        }
        return true;
    }


    /**
     * 递归方式
     */

}
