package com.yangfan.leetcode.algorithms.dp;

/**
 * 494. Target Sum
 * 目标和
 *
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * 这题回溯的"回"比较隐蔽，感觉官方题解更容易理解一点。
 *
 */
public class Target_Sum {

    public int findTargetSumWays(int[] nums, int target) {
        return bt(nums, 0, target);
    }

    int bt(int [] nums, int index, int target) {
        if(index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        return bt(nums, index + 1, target - nums[index])
                    + bt(nums, index + 1, target + nums[index]);
    }

//    int count = 0;
//
//    public int findTargetSumWays(int[] nums, int target) {
//        backtrack(nums, target, 0, 0);
//        return count;
//    }
//
//    public void backtrack(int[] nums, int target, int index, int sum) {
//        if (index == nums.length) {
//            if (sum == target) {
//                count++;
//            }
//        } else {
//            backtrack(nums, target, index + 1, sum + nums[index]);
//            backtrack(nums, target, index + 1, sum - nums[index]);
//        }
//    }


}
