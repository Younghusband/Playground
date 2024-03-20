package com.yangfan.leetcode.algorithms.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 *  和为k的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k，
 * 请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 * 核心是: 连续。。。
 *
 * 这题属于典型的，中文翻译使人理解起来花时间。。
 *
 * 核心: 前缀和+hashmap
 *
 */
public class Subarray_Sum_Equals_K {

    /**
     * 利用前缀和
     * 存储前缀和，以及对应的计数
     * 然后在下一个数获取该前缀和的计数
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumFrequency = new HashMap<>();
        sumFrequency.put(0, 1); // 初始情况，和为0的子数组有1个（空数组）
        for (int num : nums) {
            currentSum += num;
            // 检查是否存在之前的前缀和，使得 currentSum - previousSum = k
            if (sumFrequency.containsKey(currentSum - k)) {
                count += sumFrequency.get(currentSum - k);
            }
            // 更新前缀和的频率
            sumFrequency.put(currentSum, sumFrequency.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }



    /**
     * 暴力虽然很蠢，但你必须得会
     */
    public int brute(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k)
                    count++;
            }
        }
        return count;
    }




}
