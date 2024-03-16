package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;


/**
 * 25. Reverse Nodes in k-Group
 * K 个一组翻转链表
 *
 * 思路:
 * 1. 设定双指针，一头一尾指向k子链表的头和尾
 * 2. 尾指针移动k
 * 3. 保存下一个指针，断开链表，翻转前k个子链表
 * 4. 将前k个子链表的尾(也就是之前的头)，连接到下一个头
 * 5. 双指针重置到前k个已翻转链表的尾部
 *
 * 本质上是内外双指针题
 * 总的双指针用来指向k个一组的头尾，循环里的双指针用来操作翻转和链接
 */
public class Reverse_Nodes_in_k_Group {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 创建一个哑节点作为新链表的头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = dummy;

        // 记住终止条件!
        while (end.next != null) {
            // 移动end指针，找到需要翻转的子链表的末尾
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break; // 如果节点不足K个，不进行翻转

            // 断开子链表，并记录下一个子链表的起点
            ListNode preKStart = prev.next;
            ListNode nextKStart = end.next;
            end.next = null;

            // 翻转k子链表，注意翻转拿的是头结点
            prev.next = reverse(preKStart);
            // 此时的start是这个k的尾。连接翻转后的子链表到新链表上
            preKStart.next = nextKStart;

            // 更新prev和end指针，准备处理下一个k子链表
            prev = preKStart;
            end = preKStart;
        }
        return dummy.next;
    }

    // 翻转链表的函数
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // private ListNode reverse(ListNode head) {
    //     if(head == null || head.next == null) return head;
    //     ListNode pre = reverse(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return pre;
    // }

}
