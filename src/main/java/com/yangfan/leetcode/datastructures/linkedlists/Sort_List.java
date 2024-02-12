package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 148. Sort List
 * 链表排序
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * 1. 归并排序 (这道题主要学习的思路)
 * 2. 冒泡排序(会超时)
 * 3. 计数排序 (这道题最快的思路)
 *
 * 链表操作的集大成者，名副其实的链表hard题
 */
public class Sort_List {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
    }

    public int[] insertSort(int [] nums) {
        for(int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int key = nums[i];
            while(j >= 0 && nums[i] < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }


    /**
     * 堆排序
     */
    public int[] heapSort(int[] nums) {
        int n = nums.length;
        // 建立最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        // 一个个交换元素
        for (int i = n - 1; i >= 0; i--) {
            // 移动当前根到末尾
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // 调整剩余堆
            heapify(nums, i, 0);
        }
        return nums;
    }

    // 堆调整
    void heapify(int[] nums, int heapSize, int i) {
        int largest = i; // 初始化最大为根
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点
        // 如果左子节点大于根
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        // 如果右子节点大于目前最大节点
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        // 如果最大不是根
        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
            // 递归地调整受影响的子堆
            heapify(nums, heapSize, largest);
        }
    }

    /**
     * 计数排序
     */
    public ListNode countingSort(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        int max = head.val;
        int min = head.val;

        // 遍历链表，找到最大值和最小值
        while (p != null){
            min = Math.min(min,p.val);
            max = Math.max(max,p.val);
            p = p.next;
        }

        p = head;
        int[] count = new int[max - min + 1];

        // 第二次遍历链表，填充计数数组
        while(p != null){
            count[p.val - min]++; // 根据节点值更新计数数组
            p = p.next;
        }

        // 遍历计数数组，根据计数重建链表
        p = head;
        for(int i = 0; i < count.length; i++){
            while(count[i] != 0) {
                p.val = i + min; // 设置节点值，计数数组的索引加上最小值
                count[i]--; // 减少计数
                p = p.next; // 移动到下一个节点
            }
        }
        return head;
    }

    /**
     * 从顶向底的归并
     */
    public ListNode mergeFromTop(ListNode head) {
        if (head == null) return null;
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummy = new ListNode(0);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummy, curr = dummy.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummy.next;
    }


    /**
     * 自底向上的归并
     */
    public ListNode mergeFromBottom(ListNode head) {
        if (head == null) return null;
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummy, curr = dummy.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummy.next;
    }

    /**
     * 合并两个有序链表公共方法
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }



    /**
     * 使用冒泡排序训练链表操作
     */
    public ListNode bubbleSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lastOrdered = null;
        boolean hasSwapped;
        do {
            // 冒泡外层循环
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            hasSwapped = false;

            // 冒泡内层循环
            while(cur.next != null && cur != lastOrdered) {
                if(cur.val > cur.next.val) {
                    // 交换
                    hasSwapped = true;
                    ListNode tmp = cur.next;
                    cur.next = tmp.next;
                    pre.next = tmp;
                    tmp.next = cur;

                    pre = tmp;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
            lastOrdered = cur;
        } while(hasSwapped);
        return dummy.next;
    }



}
