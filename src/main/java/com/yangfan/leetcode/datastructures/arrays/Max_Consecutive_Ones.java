package com.yangfan.leetcode.datastructures.arrays;


/**
 * 485. Max Consecutive Ones
 * 最大连续 1 的个数
 *
 * 示例 1：
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 */
public class Max_Consecutive_Ones {

    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                cnt++;
                maxCount = Math.max(cnt, maxCount);
            } else {
                cnt = 0;
            }
        }
        return maxCount;
    }


}
