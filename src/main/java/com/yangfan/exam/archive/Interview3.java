package com.yangfan.exam.archive;

import java.util.Arrays;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 * 提示：
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * public int findKthLargest(int[] nums, int k) {
 *
 * }
 *
 * 这里应该用计数排序。。
 */
public class Interview3 {

    public static void main(String[] args) {
        Interview3 s = new Interview3();
//        int [] nums = {3,2,3,1,2,4,5,5,6};
        int [] nums = {3,2,1,5,6,4};
//        int k = 4;
        int k = 2;
        System.out.println(s.findKthLargest(nums, k));


//        Integer [] boxedArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
//        Arrays.sort(boxedArray, Comparator.reverseOrder());
//        return boxedArray[k - 1];
        Arrays.parallelSort(nums);


    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // 构建大根堆
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }
        int targetK = -105;
        // 取k次
        for(int i = 0; i < k; i++) {
            if(i == k - 1)
                targetK = nums[0];
            swap(nums, 0, n - i - 1);
            heapify(nums, 0, n - i);
        }
        return targetK;
    }

    void heapify(int [] nums, int i, int heapSize) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if(left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if(right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if(i != largest) {
            swap(nums, i, largest);
            heapify(nums, largest, heapSize);
        }
    }

    void swap(int [] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }







}
