package com.yangfan.leetcode.datastructures.binarytree.validate;

import com.yangfan.dataobject.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 101. Symmetric Tree
 * 对称二叉树
 * 这题虽然归到Easy，但实际我觉得属于Medium
 *
 * 检查是否是轴对称二叉树
 *
 * 1. 脑海中把树掰成两根，两个root
 * 2. 中序遍历无法判断两个子树对称性，反例[1, 2, 2, 2, null, 2]
 *
 */
public class Symmetric_Tree {

    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root, root);
    }

    boolean checkSymmetric(TreeNode p1, TreeNode p2) {
        if(p1== null && p2 == null)
            return true;
        if(p1 == null || p2 == null)
            return false;

        return p1.val == p2.val
                && checkSymmetric(p1.left, p2.right)
                && checkSymmetric(p1.right, p2.left);
    }



    /**
     * 非递归检查方法
     */
    public boolean check(TreeNode u, TreeNode v) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }


}
