package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 147. Insertion Sort List
 *
 * 对链表完成插入排序的操作
 */
public class Insertion_Sort_List {

    /**
     * 标准解法
     * 核心点:
     * 1. 已排序部分的边界节点设置
     * 2. 已排序部分的遍历节点为什么pre.next.val (因为需要用到pre.next的前一个节点pre)
     * 3. 画图来搞清楚元素插入的链表操作过程
     * 4. 下一轮插入时的节点设置 cur = lastSorted.next 而不是cur = cur.next
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // lastSorted 为已排序部分的最后一个节点，curr 为当前待排序的节点
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode pre = dummy;
                while (pre.next.val <= curr.val) {
                    pre = pre.next;
                }

                // 将当前节点插入到找到的位置
                // 将已排序部分的最后一个节点指向当前节点的下一个节点，从而将当前节点从链表中断开
                lastSorted.next = curr.next;
                // 将当前节点插入到 pre 和 pre.next 之间
                curr.next = pre.next;
                pre.next = curr;
            }
            // 移动 curr 到下一个待排序的节点
            curr = lastSorted.next;
        }
        return head;
    }



    /**
     * 遇事不决，先数组
     */
    public ListNode my(ListNode head) {
        if(head == null || head.next == null) return head;
        List<Integer> data = new ArrayList();
        ListNode p = head;
        while(p != null) {
            data.add(p.val);
            p = p.next;
        }

        for(int i = 1; i < data.size(); i++) {
            int j = i - 1;
            int key = data.get(i);
            while(j >= 0 && data.get(j) > key) {
                data.set(j + 1, data.get(j));
                j--;
            }
            data.set(j + 1, key);
        }

        p = head;
        int i = 0;
        while(p != null) {
            p.val = data.get(i++);
            p = p.next;
        }
        return head;
    }

}
