package com.yangfan.leetcode.algorithms.sorting;

/**
 * 31. Next Permutation
 * 下一个排列
 *
 * 题目介绍有点啰嗦，直接上例子。
 * 要求: 必须原地修改，只允许使用额外常数空间。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 * 核心: 理解字典序
 * 1. 先让他变大(从右往左找到增长的重点)
 * 2. 再让他没那么大()
 */
public class Next_Permutation {

    public static void main(String[] args) {
        Next_Permutation service = new Next_Permutation();
        int [] arr = {1,5,8,4,7,6,5,3,1};
        service.nextPermutation(arr);
        System.out.println(arr);
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 1. 找到止增点
        while(i >=0 && nums[i] <= nums[i + 1]) {
            i--;
        }
        // 2. 先创造一个大一点的序列
        if(i >= 0) {
            int j = nums.length - 1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    void reverse(int [] nums, int start) {
        int end = nums.length - 1;
        while(start <= end) {
            swap(nums, start++, end--);
        }
    }

    void swap(int [] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }




}
