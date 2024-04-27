package com.yangfan.leetcode.datastructures.arrays;


/**
 * 487. Max Consecutive Ones II
 * 最大连续1的个数 II
 *
 * 给定一个二进制数组 nums，你可以最多将 1 个 0 翻转为 1。找出其中最大连续 1 的个数。
 * 示例 1:
 * 输入: [1,0,1,1,0]
 * 输出: 4
 * 解释: 翻转第一个 0 可以得到最长的连续 1。当翻转以后，最大连续 1 的个数为 4。
 *
 * 核心思路就是: 收缩滞后
 */
public class Max_Consecutive_Ones_II {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0};
        System.out.println(new Max_Consecutive_Ones_II().findMaxConsecutiveOnes(nums));
    }

    /**
     * 滑动窗口
     * 1. 统计窗口中0的个数，当0的个数超过1时，左指针向右移动，缩小窗口
     * 2. 更新连续1的最大数量
     *
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count++;
            }
            // 当窗口中0的个数超过1，左指针向右移动，缩小窗口
            while (count > 1) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            // 更新连续1的最大数量
            maxCount = Math.max(maxCount, right - left + 1);
        }
        return maxCount;
    }


}
