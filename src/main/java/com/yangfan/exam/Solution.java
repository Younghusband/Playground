package com.yangfan.exam;

import java.util.*;

/**
 *
 *
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(s.findTargetSumWays(nums, target));
    }


    List<Set<Integer>> ans = new ArrayList<>();
    Set<Integer> path = new LinkedHashSet<>();

    public int findTargetSumWays(int[] nums, int target) {
        bt(nums, 0); // 得到可以加正号或者负号的子集
        int count = 0;
        for(Set<Integer> set: ans) {
            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                if(set.contains(i)) {
                    sum -= nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if(sum == target) {
                count++;
            }
        }
        return count;
    }


    public void bt(int [] nums, int start) {
        ans.add(new LinkedHashSet<>(path));
        for(int i = start; i < nums.length; i++) {
            path.add(i); // 要下标而非元素
            bt(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
