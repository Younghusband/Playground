package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

/************************************************
    * 21. Merge Two Sorted Lists
    * 
    * Merge two sorted linked lists and return it as a new list. 
    * The new list should be made by splicing together the nodes of the first two lists.
    * 
    * 1. 递归方式
    * 2. 利用哑节点头
**************************************************/

public class Merge_Two_Sorted_Lists {

    /**
     * 常规遍历
     * 然后哑结点返回
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy; // 当前遍历节点的位置
        ListNode tmp; // 用于保存未合并完 剩余的节点（要么全在l1, 要么全部在l2）
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
        tmp = l1 != null ? l1 : l2;
        cur.next = tmp;
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
        }else{
        	l2.next = mergeTwo(l1, l2.next);
        	return l2;
        }
    }


}
