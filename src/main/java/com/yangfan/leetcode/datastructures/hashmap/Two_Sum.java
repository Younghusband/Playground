package com.yangfan.leetcode.datastructures.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * 学习hashmap的用法
 *
 */
public class Two_Sum {

    /**
     * 标准解法
     */
    public int[] twoSum(int[] nums, int target) {
        // target - nums[i], index
        Map<Integer, Integer> helper = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(helper.containsKey(target - nums[i])) {
                return new int[] {i, helper.get(target - nums[i])};
            }
            helper.put(nums[i], i);
        }
        throw null;
    }

}
