package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 19. Remove Nth Node From End of List
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 1. 快慢指针
 * 2. 使用栈
 * 3. 遍历链表获取链表长度，然后删除倒数第n个节点
 *
 * 移动到len-n的节点，删除len-n+1的节点
 */
public class Remove_Nth_Node_From_End_of_List {

    /**
     * 标准快慢指针解法
     * 核心是快指针先走n+1步
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 这一大坨的目的就是让slow停留在目标node的前一个node
        for(int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    // 使用栈
    public ListNode useStack(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        Deque<ListNode> stack = new ArrayDeque();
        // 先压栈
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 弹出到该删除的前一个元素
        for(int i = 1; i <= n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return dummy.next;
    }




    /**
     * 先获得长度len
     * 然后移动到 len-n的节点 删除 len-n+1的节点
     */
    public ListNode brute(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        int len = getLen(head);
        for(int i = 0; i < len - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    /**
     * 计算长度 固定写法
     * 记得从0开始计算
     */
    int getLen(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

}
