package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

/**
 * 2. Add Two Numbers
 * 两数相加
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   Output: 7 -> 0 -> 8
   Explanation: 342 + 465 = 807.
 *
 * 这题目的要点无非是
 * 1. 一次遍历完成所有操作  时间复杂度为 max(list1,list2)  O(n)
 * 2. 如何最高效的完成一次遍历    -> 筛选条件
 * 3. 利用哑节点
 *
 */
public class Add_Two_Numbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode cur = l3;
        int carry = 0;
        int tmp = 0;
        while(l1 != null && l2 != null) {
            tmp = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            cur.next = new ListNode(tmp);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        // 看哪个剩下来
        while(l1 != null) {
            cur.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2 != null) {
            cur.next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
            cur = cur.next;
        }
        // 处理剩余进位
        if(carry > 0) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        return l3.next;
    }

    
    /**
     * 标准答案
     *
     * 思路其实是一样的，就是压缩了代码
     */
    public ListNode addTwoNumbers_editional(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    
    
    
}






