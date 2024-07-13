package com.yangfan.leetcode.datastructures.arrays;

/**
 * 189. Rotate Array
 * 轮转数组
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * 思路:
 * 1. 观察，根据取模
 * 2. 把数组轮转变为翻转问题
 */
public class Rotate_Array {

    /**
     * 这道题的正统解法
     * 1. 先整体逆转
     * 2. 逆转前k个数
     * 3. 逆转后面剩余的数
     *
     * 基于观察的思路
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 逆转数组的操作
     * 原操作，需要背诵记牢
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 根据取模重新装填
     * 思路简单，重点在于代码简练
     */
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        int [] newArr = new int[len];
        for(int i = 0; i < len; i++) {
            newArr[(i + k) % len] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, len);
    }


}
