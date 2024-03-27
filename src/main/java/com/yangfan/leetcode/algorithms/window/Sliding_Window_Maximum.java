package com.yangfan.leetcode.algorithms.window;


import java.util.PriorityQueue;

/**
 * 239. Sliding Window Maximum
 * 滑动窗口最大值
 *
 * 1. 堆
 * 2. 双端队列
 *
 */
public class Sliding_Window_Maximum {

    /**
     * 使用最大堆的思路:
     * 1. 最大堆的堆顶始终是当前窗口的最大值
     * 2. 移动窗口的时候，移除窗口边缘可能的最大值，如果堆顶下标处于窗口内则不用管
     */
    public int[] maxHeap(int[] nums, int k) {
        int len = nums.length;
        int [] result = new int[len - k + 1];
        PriorityQueue<int []> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]); // 这里的泛型很关键
        // 初始化堆
        for(int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }
        result[0] = maxHeap.peek()[0];
        // 移动窗口，并进行移除
        for(int i = k; i < len; i++) {
            // 添加和移除的顺序不能颠倒
            maxHeap.offer(new int[]{nums[i], i});
            // 移除堆中不在窗口范围内，且会干扰到当前最大值判断的元素
            while(maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
            result[i - k + 1] = maxHeap.peek()[0];
        }
        return result;
    }

    /**
     * 使用双端队列
     */
    public int[] deque(int[] nums, int k) {
        int len = nums.length;
        int [] result = new int[len - k + 1];


        return result;
    }


}
