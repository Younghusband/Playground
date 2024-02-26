package com.yangfan.leetcode.algorithms.sorting;


/**
 * 75. Sort Colors
 * 颜色分类
 *
 * 给定一个包含红色、白色和蓝色、共n个元素的数组nums，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 快速排序进阶优化的基础
 * 划分为三个区域 > = <, 小于区初始为-1，大于区初始为len，各在数组两侧边界外。
 * 1. num == key, i++
 * 2. num < key, i位置的数与小于区右一位交换，小于区右扩(less++)，i++
 * 3. num > key, i位置的数与大于区左一位交换，大于区左扩(right--)，i不变，留着下一次比较
 */
public class Sort_Colors {


    public void sortColors(int[] nums) {
        if(nums.length == 1) return;
        int less = -1;
        int more = nums.length;
        int i = 0;
        while(i < more) {
            if(nums[i] == 1) {
                i++;
            } else if(nums[i] == 0) {
                swap(nums, less + 1, i);
                less++;
                i++;
            } else {
                swap(nums, more - 1, i);
                more--;
            }
        }
    }

    void swap(int [] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }


}
