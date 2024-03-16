package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * 合并 K 个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 1. 使用最小堆
 *
 */
public class Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode node : lists) {
            if(node != null) { // 测试用例里数组中有null
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!heap.isEmpty()) {
            ListNode minNode = heap.poll();
            cur.next = minNode;
            cur = cur.next; // 记得移动针
            // 某根链表移动完毕
            if(minNode.next != null) {
                heap.offer(minNode.next);
            }
        }
        return dummy.next;
    }


}
