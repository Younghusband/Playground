package com.yangfan.leetcode.algorithms.searching;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 两种思路
 * 1. 先找到目标值，然后从中心扩散出来一个完整的区间
 * 2. 两次二分法，分别求出左右边界
 */

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    /**
     * 中心扩散法
     */
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int [] result = {-1, -1};
        while(left <= right) {
            int mid = left + right >>> 1;
            if(nums[mid] == target) {
                // 向两侧扩，搜集开头和结尾 core
                while(nums[left] != target) {
                    left++;
                }
                while(nums[right] != target) {
                    right--;
                }
                return new int[]{left, right};
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

}
