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
     * 我的蠢逼边界判断
     */
    public int my(int[] nums, int target) {
        if(nums.length == 1)
            return nums[0] == target ? 0 : (target < nums[0] ? 0 : 1);
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int mid = -1;
        while(startIndex < endIndex) {
            mid = (startIndex + endIndex) >>> 1;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        // 处理最后一次二分跳出未找到情况
        return target <= nums[startIndex]  ? startIndex : startIndex + 1;
    }

    /**
     * 优美的边界包含
     */
    public int searchInsert(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int mid;
        while (startIndex <= endIndex) {
            mid = (startIndex + endIndex) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return startIndex;
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
