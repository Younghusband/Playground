package com.yangfan.leetcode.algorithms.window;

import java.util.Arrays;

/**
 * 209. Minimum Size Subarray Sum
 * 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于target的长度最小的连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 *
 */
public class Minimum_Size_Subarray_Sum {

    /**
     * 滑动窗口动态维护数组和
     * 1. 大于则左侧收缩
     * 2. 小于则右侧扩张
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        while(right < nums.length) {
            sum += nums[right];
            // 符合条件，收缩窗口
            while(sum >= target) {
                len = Math.min(len, right - left + 1);
                sum -= nums[left++];
            }
            // 条件破坏，扩大窗口
            right++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }


    /**
     * 了解
     * 效率不如滑动窗口
     */
    public int prefixArray(int target, int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0; // 如果数组为空，直接返回0
        int ans = Integer.MAX_VALUE; // 最小长度初始化为最大整数
        int[] sums = new int[n + 1]; // 创建前缀和数组，长度为n+1，sums[0]为0
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1]; // 计算前缀和
        }
        for (int i = 1; i <= n; i++) {
            int key = target + sums[i - 1]; // 确定当前位置所需的目标前缀和
            int bound = Arrays.binarySearch(sums, key); // 二分查找目标前缀和的位置
            if (bound < 0)
                bound = -bound - 1; // 如果未找到，bound为应插入位置的负数
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1)); // 更新最小长度
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans; // 如果未找到有效的子数组，返回0
    }



}
