package com.yangfan.leetcode.algorithms.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 15. 3Sum
 * 三数之和
 *
 * nums[i], nums[left], nums[right]
 *
 * 难点在于剪枝
 * 剪枝可以优化执行效率，也可以让你原本可以对的代码变错。。。
 *
 *
 */
public class Three_Sum {

    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 2; i++) {
            int cur = nums[i];
            int left = i + 1, right = len - 1;
            // 当前值已大于目标值，退出
            if(cur > target) break; // 仅适用于这道题， 不适用于4数之和
            // 当前最小和大于0，后续无解，退出
            if(cur + nums[left] + nums[left + 1] > target) {
                break;
            }
            // 已经在上一轮判断过了
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            // 最大和小于目标值，说明当前值不需要做判断，直接跳到下一个
            if(cur + nums[len - 1] + nums[len - 2] < target) {
                continue;
            }
            while(left < right) {
                int sum = cur + nums[left] + nums[right];
                if(sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }


}
