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
        if(head == null || head.next == null) { //空链表或者已经到链表末尾
            return head;
        }
        ListNode prev = reverse(head.next);
        head.next.next = head;  // 折返
        head.next = null;       // 剪断正向next
        return prev;
    }

}
