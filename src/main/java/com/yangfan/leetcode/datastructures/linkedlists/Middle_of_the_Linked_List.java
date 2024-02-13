package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

/**
 * 876. Middle of the Linked List
 *
 * 略
 */
public class Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head) {
        if(head.next == null) return head;

        ListNode f = head;
        ListNode s = head;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
