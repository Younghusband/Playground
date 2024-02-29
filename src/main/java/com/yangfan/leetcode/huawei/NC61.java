package com.yangfan.leetcode.huawei;

import java.util.HashMap;
import java.util.Map;

public class NC61 {

    public static void main(String[] args) {
        NC61 nc61 = new NC61();
        int [] result = nc61.twoSum(new int [] {3,2,4}, 6);
        // 打印数组
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> helper = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(helper.containsKey(target - nums[i])) {
                return new int [] {helper.get(target - nums[i]) + 1, i + 1};
            }
            helper.put(nums[i], i);
        }
        return new int [] {};
    }

}
