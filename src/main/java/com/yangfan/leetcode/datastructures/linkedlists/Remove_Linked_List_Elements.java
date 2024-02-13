package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

/**
 * 203. Remove Linked List Elements
 * 给你一个链表的头节点 head 和一个整数 val
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点.
 *
 */
public class Remove_Linked_List_Elements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next; // 灵魂，cur在此情况原地不动
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
