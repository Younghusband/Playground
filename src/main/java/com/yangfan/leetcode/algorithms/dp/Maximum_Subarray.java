package com.yangfan.leetcode.algorithms.dp;


/************************************************
 *  53. Maximum Subarray
 *  最大子数组和
 *
 *  Find the contiguous subarray within an array (containing at least one number)
 *  which has the largest sum.
 *  For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 *  the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 *  1. 动态规划
 *  2. 贪心
 *  3. 暴力
**************************************************/
public class Maximum_Subarray {
	
	public static void main(String[] args) {
		int [] arr = {};
		int maxInt = maxSubArray(arr);
		System.out.println(maxInt);
	}

    /**
     * 从左至右  一个用来探索  一个用来保存进度
     */
    public static int maxSubArray(int[] nums) {
        int maxSofar = nums[0]; int maxEndingHere = nums[0];
    	for(int i = 1; i < nums.length; i++) {
    		maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
    		maxSofar = Math.max(maxSofar, maxEndingHere);
    	}
    	return maxSofar;
    }

	/**
	 * 贪心的思路
	 */
	public int greedy(int[] nums) {
		int maxValue = nums[0];  // 记录历史最大值
		int preSum = nums[0]; // 记录当前元素之前的累加值
		for(int i = 1; i < nums.length; i++) {
			if(preSum < 0) {
				preSum = 0;
			}
			preSum += nums[i];
			maxValue = Math.max(maxValue, preSum);
		}
		return maxValue;
	}

	/**
	 * 有一说一
	 * 暴力虽然最慢，但感觉确是最难想的
	 */
	public int brute(int [] nums) {
		int sum = 0;
		int max = nums[0];
		// 从nums[i] 开始的所有子序列
		for(int i = 0; i < nums.length; i++) {
			sum = 0; // 清零上一轮num[i-1]开头的累加值
			for(int j = i; j < nums.length; j++) {
				sum += nums[j];
				max = Math.max(sum, max);
			}
		}
		return max;
	}
	
}
