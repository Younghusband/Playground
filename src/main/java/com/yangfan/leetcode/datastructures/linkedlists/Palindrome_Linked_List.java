package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 234. Palindrome Linked List
 * 回文链表
 * Given the head of a singly linked list, return true if it is a
 * palindrome or false otherwise.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 *
 * 知识点:
 * 1. 翻转链表(1次 or 2次)
 * 2. 找链表中点
 */
public class Palindrome_Linked_List {

    /**
     * 标准思路
     * 1. 快慢指针找中点
     * 2. 翻转中点后面的链表
     * 3. 比较前后半段链表
     * 4. 翻转后半段，恢复链表
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        // 找到链表中点
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表
        ListNode reverseHead = reverse(slow.next);
        // 比较前半部分和反转后的后半部分链表
        ListNode p1 = head, p2 = reverseHead;
        while(p2 != null) { // 只需要遍历反转的后半部分
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // （可选）恢复原链表的结构，反转回后半部分链表
        slow.next = reverse(reverseHead);
        return true;
    }

    // 反转链表函数
    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * 使用栈
     * 思路比较简单，但是效率低
     */
    public boolean useStack(ListNode head) {
        Deque<Integer> stack = new ArrayDeque(); // 比上面又快了一点
        ListNode cur = head;
        while(cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            if(cur.val != stack.pop())
                return false;
            cur = cur.next;
        }
        return true;
    }

    /**
     * 我的解法
     * 搓在 翻转整个链表，慢
     */
    public boolean my(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode reverseHead = copyAndReverse(head);
        ListNode cur = head;
        while(cur != null) {
            if(cur.val != reverseHead.val)
                return false;
            cur = cur.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    ListNode copyAndReverse(ListNode head) {
        return reverse(copy(head));
    }

    ListNode copy(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(head != null){
            cur.next = new ListNode(head.val);
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }

//    ListNode reverse(ListNode head) {
//        if(head == null || head.next == null) return head;
//        ListNode pre = reverse(head.next);
//        head.next.next = head;
//        head.next = null;
//        return pre;
//    }


    /**
     * 递归
     */
    public boolean isPalindromeRe(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
    private ListNode frontPointer;
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            // 如果递归检查返回false，则提前返回false
            if (!recursivelyCheck(currentNode.next)) return false;
            // 比较当前节点与前节点的值
            if (currentNode.val != frontPointer.val) return false;
            // 移动头指针
            frontPointer = frontPointer.next;
        }
        return true;
    }


}
