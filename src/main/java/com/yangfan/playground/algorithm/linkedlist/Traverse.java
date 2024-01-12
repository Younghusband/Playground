package com.yangfan.playground.algorithm.linkedlist;

import com.yangfan.dataobject.ListNode;

import java.util.Stack;

/**
 * 单链表的正序，逆序遍历
 *
 * 难点在于反转链表的编织手法，以及java值传递的问题
 */
public class Traverse {


    public static void main(String[] args) {
        // 初始化一个链表数据
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);

        head.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        traverse(head);

        System.out.println(">>>>>>>逆序>>>>>>>>>>");

//        print(reverse(head));
        reverseNotReturn(head);
        print(head);

//        int [] arr = {1,2,3,4,5};
//        arrProcess(arr);
//        printArr(arr);

    }

    public static void traverse(ListNode head) {
        while(head != null) {
            int val = head.val;
            head = head.next;
            System.out.println(val);
        }
    }

    /**
     * 逆序遍历和逆序一个链表是不一样的
     *
     * 前者是遍历，后者是改变链表的结构
     */

    public static void reversePrint(ListNode head) {
        if(head == null) {
            return;
        }
        reversePrint(head.next);
        System.out.println(head.val);
    }


    /**
     * 反转了，但也没反转
     */
    public static void reverseNotReturn(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while(cur != null) {
            next = cur.next; // 先保存next
            cur.next = prev; // 掉头
            prev = cur; // 前指针指向当前值
            cur = next; // 将当前指针移动到保存的下一个值
        }
    }

    /**
     * 一针一针编织
     */
    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode next;
        ListNode prev = null;
        // 下一个节点为null就停
        while(cur != null) {
            next = cur.next;  // 保存下一个节点
            cur.next = prev;  // 掉头
            prev = cur; // prev指向当前节点
            cur = next; // 游标前进
        }
        return prev;
    }

    public static void reversePrintByStack(ListNode head) {
        if(head == null) {
            return;
        }
        Stack<ListNode> helper = new Stack<>();
        while(head != null) {
            helper.push(head);
            head = head.next;
        }

        while(!helper.isEmpty()) {
            System.out.println(helper.pop().val);
        }
    }

    public static void print(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


//    public static void arrProcess(int [] arr) {
//        int [] arr1 = arr;
//        // 将数组中每个数变为0
//        for(int i = 0; i < arr.length; i++) {
//            arr1[i] = 0;
//        }
//    }
//
//    // 打印数组
//    public static void printArr(int [] arr) {
//        for(int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }















}
