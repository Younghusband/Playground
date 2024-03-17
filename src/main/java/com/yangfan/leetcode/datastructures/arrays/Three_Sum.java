package com.yangfan.leetcode.datastructures.arrays;

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
 *
 */
public class Three_Sum {

    public static void main(String[] args) {
        Three_Sum service = new Three_Sum();
        int [] arr = {2, 2, 3, 3, 4, 4};
        // 打印
        for(List<Integer> list : service.threeSum(arr, 9)) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 2; i++) {
            int cur = nums[i];
            if(cur > target) break;
            int left = i + 1, right = len - 1;
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            // 最大和小于0，说明当前值不需要做判断，直接跳到下一个
            if(cur + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            // 当前最小和大于0，后续无解，跳出
            if(cur + nums[left] + nums[left + 1] > target) {
                break;
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
