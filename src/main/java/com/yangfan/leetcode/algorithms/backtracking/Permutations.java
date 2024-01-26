package com.yangfan.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. Permutations
 * 全排列
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations {

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        Permutations permutations = new Permutations();
        List<List<Integer>> data = permutations.permute(arr);
        System.out.println(data);
    }


    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
//        doPermute(nums, 0, ans);
        boolean [] used = new boolean[nums.length];
        backTrack(nums, used);
        return ans;
    }


    void backTrack(int [] nums, boolean [] used) {
        if(path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTrack(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


    /**
     * 不太好理解，但是没用额外空间
     */
    private static void doPermute(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            LinkedList<Integer> permutation = new LinkedList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                doPermute(nums, i + 1, result);
                swap(nums, i, j);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
