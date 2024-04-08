package com.yangfan.leetcode.datastructures.arrays;

/**
 * 238. Product of Array Except Self
 * 除自身以外数组的乘积
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 * 思路:
 * 不能用除法，结合上面实例想想为什么
 * 1. 前缀积 + 后缀积
 * 2.
 *
 */
public class Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] pre = new int[len]; // 前缀🐔
        int [] after = new int[len]; // 后缀🐔
        int [] ans = new int[len];

        // 构造前缀鸡数组
        pre[0] = nums[0];
        for(int i = 1; i < len - 1; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }
        // 构造后缀鸡数组
        after[len - 1] = nums[len - 1];
        for(int j = len - 2; j > 0; j--) {
            after[j] = after[j + 1] * nums[j];
        }

        for(int i = 0; i < len; i++) {
            if(i == 0)
                ans[i] = after[i + 1];
            else if(i == len - 1)
                ans[i] = pre[i - 1];
            else
                ans[i] = pre[i - 1] * after[i + 1];
        }
        return ans;
    }

}
