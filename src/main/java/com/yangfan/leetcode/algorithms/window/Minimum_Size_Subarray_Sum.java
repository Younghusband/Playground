package com.yangfan.leetcode.algorithms.window;

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

//    public int prefixSum(int target, int[] nums) {
//
//
//    }





}
