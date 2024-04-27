package com.yangfan.leetcode.datastructures.arrays;

/**
 * 1004. Max Consecutive Ones III
 * 最大连续1的个数 III
 *
 * 这题是傻逼吧，跟 487. Max Consecutive Ones II 一模一样，1变成k而已
 * 代码都不用改，直接复制粘贴就行
 *
 */
public class Max_Consecutive_Ones_III {

    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int left = 0;
        int zeroCnt = 0;
        for(int right = 0; right < nums.length; right++) {
            // 存在0，先计数
            if(nums[right] == 0) {
                zeroCnt++;
            }
            // 0 数量超过了阈值，收缩窗口
            while(zeroCnt > k) {
                if(nums[left] == 0) {
                    zeroCnt--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }


}
