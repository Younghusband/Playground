package com.yangfan.leetcode.datastructures.linkedlists;


import com.yangfan.dataobject.ListNode;

/**
 * 206. Reverse Linked List
 *
 * Given the head of a singly linked list,
 * reverse the list, and return the reversed list.
 *
 * 反转链表
 *
 * 核心思想:
 * head.next.next = head;
 * head.next = null;
 *
 * 思考如何不改变原来的链表，反转出一个新的链表。
 */
public class Reverse_Linked_List {
    
    /**
     * 非递归方法
     *
     * 需要注意的点是，最后返回pre节点
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode tmp = null;
        while(head != null){
            tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;        
    }
    
    /**
     * 递归方法
     * 需要注意的点是终止条件，以及子问题流程
     *
     * 反转的核心就是 head.next.next = head;
     *
     */
    public ListNode reverse(ListNode head){
        // 基本情况：如果链表为空或只有一个节点，直接返回头节点
        if(head == null || head.next == null) return head;

        ListNode pre = reverse(head.next);
        head.next.next = head;
        head.next = null;

        // 在每层递归中，返回最后一个节点，即反转后的新头节点
        return pre;
    }

}
