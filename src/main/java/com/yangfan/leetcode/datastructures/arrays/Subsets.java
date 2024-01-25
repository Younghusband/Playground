package com.yangfan.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given an integer array nums of unique elements,
 * return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 */
public class Subsets {

    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> data = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), data);
        return data;
    }

    private void backtrack(int start, int[] nums,
                           List<Integer> current, List<List<Integer>> data) {
        data.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, nums, current, data);
            current.remove(current.size() - 1); // 回溯
        }
    }


}
