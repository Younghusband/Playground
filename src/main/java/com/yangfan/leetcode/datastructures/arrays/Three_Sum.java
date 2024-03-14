package com.yangfan.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 15. 3Sum
 * 三数之和
 *
 * nums[i], nums[left], nums[right]
 */
public class Three_Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            int cur = nums[i];
            int left = i + 1, right = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            while(left < right) {
                int sum = cur + nums[left] + nums[right];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }


}
