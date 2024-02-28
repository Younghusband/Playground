package com.yangfan.leetcode.datastructures.trees.validate;

import com.yangfan.dataobject.ListNode;
import com.yangfan.dataobject.TreeNode;

/**
 * 1367. Linked List in Binary Tree
 *  二叉树中的链表
 *
 * 给你一棵以root为根的二叉树和一个head为第一个节点的链表。
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以head为首的链表中每个节点的值，
 * 那么请你返回True ，否则返回False。
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 *
 */
public class Linked_List_in_Binary_Tree {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        // 检查当前节点或其左右子树是否匹配链表
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode node) {
        // 链表遍历完毕，找到匹配路径
        if (head == null) return true;
        // 二叉树路径结束，链表未遍历完毕
        if (node == null) return false;
        // 当前节点值不匹配
        if (head.val != node.val) return false;
        // 继续匹配左右子树
        return dfs(head.next, node.left) || dfs(head.next, node.right);
    }


}
