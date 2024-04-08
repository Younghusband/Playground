package com.yangfan.leetcode.algorithms.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 *
 * 不管是3 sum 几sum
 * 都有个前提就是
 * 解数组是不重复的
 * 所以，这也是为什么要跳过重复值去处理
 *
 * 4 sum相比3 sum，无非是剪枝重复一次，循环多一层
 *
 */
public class Four_Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        if(nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 3; i++) {
            int one = nums[i];
            // 剪枝1.1 当前值被处理过
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 剪枝1.2 最小加和已超过目标值 提前结束
            if((long)one + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 剪枝1.3 当前最大和小于目标值 进入下一组
            if((long)one + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for(int j = i + 1; j < len - 2; j++) {
                int two = nums[j];
                // 剪枝2.1
                if(j > i + 1 && two == nums[j - 1]) {
                    continue;
                }
                // 剪枝2.2
                if((long)one + two + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // 剪枝2.3
                if((long)one + two + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while(left < right) {
                    int sum = one + two + nums[left] + nums[right];
                    if(sum == target) {
                        res.add(Arrays.asList(one, two, nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if(sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        return res;
    }

}
