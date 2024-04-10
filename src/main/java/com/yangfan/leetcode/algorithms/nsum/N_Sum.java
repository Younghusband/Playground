package com.yangfan.leetcode.algorithms.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n sum问题通解
 *
 * 入参: 数组nums, n个数, 目标和target
 *
 * 核心思路就是把问题降维到n-1, 直到2个数, 转化为 two sum问题
 *
 */
public class N_Sum {

    /**
     * 三数之和
     */
    public List<List<Integer>> threeSum(int[] nums) {
        return nSum(nums, 3, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum(nums, 4, target);
    }

    /**
     * nSum通解
     */
    public List<List<Integer>> nSum(int[] nums, int n, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || len < n) return res;
        Arrays.sort(nums); // O(nlogn)
        if (n == 2) {
            // 双指针解决 Two Sum 问题
            int left = 0, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> subRes = new ArrayList<>();
                    subRes.add(nums[left]);
                    subRes.add(nums[right]);
//                    res.add(Arrays.asList(nums[left], nums[right])); // 思考为什么不能用这种方式添加
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            // 递归解决 n-1 sum 问题
            for (int i = 0; i < len - n + 1; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复元素
                List<List<Integer>> subRes = nSum(Arrays.copyOfRange(nums, i + 1, len), n - 1, target - nums[i]);
                for (List<Integer> list : subRes) {
                    list.add(0, nums[i]); // 在每个结果的开头添加当前元素
                    res.add(list);
                }
            }
        }
        return res;
    }


}
