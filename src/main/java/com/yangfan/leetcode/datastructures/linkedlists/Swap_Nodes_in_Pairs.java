package com.yangfan.leetcode.datastructures.linkedlists;


import com.yangfan.dataobject.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * 两两交换链表中的节点
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 有趣的一点是，要注意整个结果链表的头是原来链表的第二个节点。
 *
 * 1. 递归
 * 2. 非递归
 * 3. 使用反转k个一组的代码，k传2  典型用hard解决medium
 */
public class Swap_Nodes_in_Pairs {

    /**
     * 递归解法
     */
    public ListNode swapPairs(ListNode head) {
        // 终止条件：如果链表为空或只有一个节点，直接返回头节点
        if (head == null || head.next == null) return head;

        ListNode one = head;
        ListNode two = head.next;
        ListNode three = two.next;

        // 交换节点one和节点two
        two.next = one;
        // 递归交换后续节点对，并将结果连接到节点one上
        one.next = swapPairs(three);

        // 返回新的头节点two
        return two;
    }


    /**
     * 非递归解法
     */
    public ListNode swapPairsIterative(ListNode head) {
        // 创建一个哑节点，其next指向头节点，方便处理头节点的交换
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        // 当还有至少两个节点可以交换时，进行循环
        while (prev.next != null && prev.next.next != null) {
            // one为当前要交换的第一个节点，two为第二个节点
            ListNode one = prev.next;
            ListNode two = one.next;
            // 进行节点交换
            one.next = two.next;
            two.next = one;
            // 不能断链，pre还要连上交换后的头结点
            prev.next = two;
            // 更新prev指针，移动到下一对要交换的节点的前一个节点
            prev = one;
        }

        // 返回新的头节点，即哑节点的下一个节点
        return dummy.next;
    }





}
