package com.yangfan.leetcode.datastructures.arrays;

import java.util.Arrays;

/**
 * 41. First Missing Positive
 * 缺失的第一个正数
 *
 * 脑筋急转弯么？
 */
public class First_Missing_Positive {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for(int num: nums) {
            if(num == res)
                res++;
        }
        return res;
    }


}
