package com.yangfan.leetcode.algorithms.searching;


/**
 * 35. Search Insert Position
 * 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 */
public class Search_Insert_Position {

    /**
     * 优美的边界包含
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 搜索条件精简版
     * 要不死记硬背吧
     */
    public int searchInsert1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) { // 为什么包含等于
            int mid = (left + right) >>> 1;
            if(nums[mid] < target) {
                left = mid + 1;
            } else { // 为什么 >= 的情况right都为mid - 1
                right = mid - 1;
            }
        }
        return left; // 为什么返回left
    }




    /**
     * 聪明，但不合规的暴力
     */
    public int bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] >= target)
                return i;
        return nums.length;
    }



}
