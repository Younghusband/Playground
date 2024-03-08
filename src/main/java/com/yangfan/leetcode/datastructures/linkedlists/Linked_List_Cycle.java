package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 * 判断链表中是否包含环，如果包含环返回true，否则false
 * 
 * 收获:
 * 1. 快慢指针思想
 * 2. 空指针的甄别和处理
 *
 */
public class Linked_List_Cycle {


    /**
     * slow and fast pointer
     * 经典思路
     * 快但内存占用大
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 只需要关心快指针的边界问题
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; // 规避起点情况
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 内存小但耗时长
     */
    public boolean useSet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    

}
