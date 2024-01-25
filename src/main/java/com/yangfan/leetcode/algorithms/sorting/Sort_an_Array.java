package com.yangfan.leetcode.algorithms.sorting;


/**
 * 912. Sort an Array
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 提示：
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 *
 * 这题的坑点在于，你用O(n^2)的排序算法，会超时。
 * 所以要用O(nlogn)的排序算法。
 * O(nlogn)的排序算法有：
 * 快速排序、归并排序、堆排序、希尔排序、计数排序、桶排序、基数排序。
 * 这里面，计数排序、桶排序、基数排序不适合这道题，因为这三种排序算法都是非比较排序，需要额外的空间。
 *
 * 1. 快速排序 普通快排会超时
 * 2. 归并排序
 * 3. 堆排序
 * 4. 希尔排序
 *
 *
 */
public class Sort_an_Array {

    public int[] sortArray(int[] nums) {
        if(nums.length == 1) return nums;
        process(nums, 0, nums.length - 1);
        return nums;
    }

    void process(int[] nums, int l, int r) {
        int mid = (l + r) >>> 1;
        if(l < r) {
            process(nums, l, mid);
            process(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    void merge(int []nums, int left, int mid, int right) {
        // 新开辟一个数组
        int [] temp = new int[right - left + 1];
        // 合并 [left, mid] 与 [mid + 1, right] 区间
        int p1 = left;
        int p2 = mid + 1;
        int k = 0;
        while(p1 <= mid && p2 <= right) {
            temp[k++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        // p1有剩余
        while(p1 <= mid) {
            temp[k++] = nums[p1++];
        }
        // p2有剩余
        while(p2 <= right) {
            temp[k++] = nums[p2++];
        }

        // 把temp数组的值全部灌入原nums
        System.arraycopy(temp, 0, nums, left, right - left + 1);
    }





}
