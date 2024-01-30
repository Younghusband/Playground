package com.yangfan.leetcode.datastructures.arrays;

/**
 * 283. Move Zeroes
 * Given an integer array nums,
 * move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * 这题其实挺有意思的
 */
public class Move_Zeros {

    /**
     * 效率相对较高一些，没有发生交换
     */
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // 集中存放0的最左侧下标
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public void moveZeroe1(int[] nums) {
        int noZeroEnd = 0; // 非0的右边界
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[noZeroEnd];
                nums[noZeroEnd++] = temp;
            }
        }
    }



}
