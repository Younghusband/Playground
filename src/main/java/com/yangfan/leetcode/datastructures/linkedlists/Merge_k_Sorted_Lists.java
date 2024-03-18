package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

import java.util.*;

/**
 * 23. Merge k Sorted Lists
 * 合并 K 个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 1. 使用最小堆
 * 2. 全部遍历排序完重新怼
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

    /**
     * 时间复杂度O(n^2)
     */
    public ListNode brute(ListNode[] lists) {
        List<Integer> data = new ArrayList();
        for(ListNode node : lists) {
            while(node != null) {
                data.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(data);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for(Integer num : data) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }


}
