package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

/************************************************
* 21. Merge Two Sorted Lists

     Merge two sorted linked lists and return it as a new list.
     The new list should be made by splicing together the nodes of the first two lists.

   1. 递归方式
   2. 利用哑节点头

 合并两个有序链表。

 核心代码是:
 ListNode dummy = new ListNode(-1);
 ListNode cur = dummy;


**************************************************/

public class Merge_Two_Sorted_Lists {


    public static void main(String[] args) {
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        ListNode fuck = cur;
//
//        ListNode head = new ListNode(1);
//        ListNode node1 = new ListNode(3);
//        ListNode node2 = new ListNode(5);
//        ListNode node3 = new ListNode(7);
//        ListNode node4 = new ListNode(9);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = null;
//
////        cur = new ListNode(-10);  // 如果cur重新赋值，就会和dummy断开关系
////        cur = cur.next;
//        cur.next = head;
//        fuck.next = head.next;
//
//        ListNode t = dummy.next;
//        while(t != null) {
//            System.out.print(t.val + "->");
//            t = t.next;
//        }

        System.out.println(7/10);
    }


    /**
     * 常规遍历
     * 然后哑结点返回
     *
     * 最让我费解的就是 cur = dummy
     * 然后cur不断的往后移动，最后返回dummy.next
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy; // 当前遍历节点的位置
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next; // 记得将指针递进
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    /**
     * 经典递归方式
     */
    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val < l2.val){
        	l1.next = mergeTwo(l1.next, l2);
        	return l1;
        } else {
        	l2.next = mergeTwo(l1, l2.next);
        	return l2;
        }
    }


}
