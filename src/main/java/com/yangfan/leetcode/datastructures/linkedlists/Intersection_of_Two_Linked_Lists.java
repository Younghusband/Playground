package com.yangfan.leetcode.datastructures.linkedlists;


import com.yangfan.dataobject.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. Intersection of Two Linked Lists
 *
 * 题目数据保证整个链式结构中无环。有环的另开题讨论
 * 相交链表，返回相交的节点，如果没有返回null
 *
 * 想办法让两个节点同时走到相交点
 * 思路1 : 先各自遍历，得到两个链表的长度，然后利用差值让两个链表同时到交点
 * 思路2 : 链表A遍历完遍历链表B，链表B遍历完遍历链表A，这样两个指针一定会同时到达交叉点。
 */
public class Intersection_of_Two_Linked_Lists {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.setNext(node2);

        node3.setNext(node4);


        System.out.println(proSolution(node1, node3));
    }

    /**
     * 这思路打死我也想不到。。
     * 假设链表1的长度为a，链表2的长度为b，两个链表的交叉部分长度为c，那么有：
     * a + b - c = b + a - c
     *
     * 为什么这样就能找到交叉点呢？
     * 因为两个指针走的长度相等，所以两个指针一定会同时到达交叉点。
     *
     * 如果两个链表没有交叉点，那么两个指针会同时到达链表的尾部，此时两个指针都为null，也能满足条件。
     */
    public static ListNode proSolution(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if(p1 != null)
                p1 = p1.next;
            else
                p1 = headB;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if(p2 != null)
                p2 = p2.next;
            else
                p2 = headA;
        }
        return p1;
    }


    /**
     * 1. 分别遍历两个list，并记录长度差值n
     * 2. 根据长度差值，让长链表晚n出发，相遇点即为交叉点
     *
     * 值得注意的几个点:
     * 1. 第一次遍历两个链表的时候，只需要走到最后一个点，而不需要继续走到null，然后拿最后两个node进行比较
     * 2. n通过加减的方式节省了变量
     */
    public ListNode normalSolution(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode longHead = headA;
        ListNode shortHead = headB;
        int n = 0;
        while(longHead.next != null) {
            n++;
            longHead = longHead.next;

        }
        while(shortHead.next != null) {
            n--;
            shortHead = shortHead.next;
        }
        if(longHead != shortHead) {
            return null;
        }
        // 根据n的值决定谁长谁短，长的先遍历
        longHead = n > 0 ? headA : headB; // n > 0则说明headA长一些
        shortHead = longHead == headA ? headB : headA; // cur2就选短的
        n = Math.abs(n); // 这步别漏了
        while(n != 0) {
            n--;
            longHead = longHead.next;
        }
        while(longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }



    /**
     * 本人相对比较蠢的方法
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> helper = new HashSet<>();
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1 != null) {
            helper.add(cur1);
            cur1 = cur1.next;
        }
        while(cur2 != null) {
            if(helper.contains(cur2)) {
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }


}
