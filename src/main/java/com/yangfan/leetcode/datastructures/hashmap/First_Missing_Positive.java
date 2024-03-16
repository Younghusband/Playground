package com.yangfan.leetcode.datastructures.hashmap;


import java.util.Arrays;

/**
 * 41. First Missing Positive
 * 缺失的第一个正数
 *
 * 脑筋急转弯呢这
 */
public class First_Missing_Positive {

    /**
     * 求的是缺失的第一个最小的正数
     * 所以排序后从1开始比较
     */
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for(int num : nums){
            if(num == res) {
                res++;
            }
        }
        return res;
    }


}
