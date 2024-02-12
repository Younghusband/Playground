package com.yangfan.leetcode.trick.bitmanipulation;

/**
 * 136. Single_Number
 *
 * Given a non-empty array of integers nums,
 * every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * 没啥好说的
 * 1. 0和任何数异或都是这个数本身
 * 2. 任何数和自己异或都是0
 * 3. 异或满足交换律
 */

public class Single_Number {

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Single_Number single_number = new Single_Number();
        int[] nums = {4,1,2,1,2};
        System.out.println(single_number.singleNumber(nums));
    }

}
