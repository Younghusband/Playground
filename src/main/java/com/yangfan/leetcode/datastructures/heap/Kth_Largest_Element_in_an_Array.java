package com.yangfan.leetcode.datastructures.heap;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * Given an integer array nums and an integer k,
 * return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 *
 * 1. 堆排序 标准解法
 * 2. 快速排序
 * 3. 计数排序 适用于数据范围有限的情况，也就是此题的情况
 * 4. 使用优先队列，小根堆/大根堆
 *
 */
public class Kth_Largest_Element_in_an_Array {

    /**
     * 基于堆排序的选择k方法
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return nums[0];
        // 构建最大堆
        for(int i = n/2 - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }
        // 逐个将堆顶元素弹出，放至队尾，弹出第k次返回
        for(int i = n - 1; i >= n - k; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
        return nums[n - k];
    }

    void heapify(int [] nums, int i, int heapSize) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }

        if(right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }

        if(largest != i) {
            swap(nums, i, largest);
            heapify(nums, largest, heapSize);
        }
    }

    /**
     * 基于计数排序的选择k方法
     */
    public int countingSelectK(int[] nums, int k) {
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }

    /**
     * 使用小根堆
     */
    public int littleRootHeap(int [] nums, int k) {
        // 小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for(int num: nums) {
            if(queue.size() == k) {
                // 小根堆堆顶小于新元素
                if(queue.peek() < num) {
                    queue.poll();
                    queue.offer(num);
                }
            } else {
                queue.offer(num);
            }
        }
        return queue.peek();
    }

    /**
     * 使用大根堆
     */
    public int bigRootHeap(int [] nums, int k) {
        // 大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 全部灌入大根堆
        for(int num: nums) {
            queue.offer(num);
        }
        // 取到第k个
        for(int i = 1; i <= k; i++) {
            Integer data = queue.poll();
            if(i == k) return data;
        }
        return 0;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
