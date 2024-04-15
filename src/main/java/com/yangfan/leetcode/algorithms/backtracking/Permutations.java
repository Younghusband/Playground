package com.yangfan.leetcode.algorithms.backtracking;

import java.util.ArrayList;
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
 *
 * 思路:
 * 1. 使用boolean [] used记录元素在递归上下层的使用情况
 * 2. 排列数组，递归结束交换回去
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
        boolean [] used = new boolean[nums.length];
        bt(used, nums);
        return ans;
    }


    void bt(boolean [] used, int [] nums) {
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
            bt(used, nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    /**
     * 数组上直接进行交换
     */
    private void doPermute(int cur, int[] nums) {
        if (cur == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            ans.add(permutation);
        } else {
            // core
            for (int j = cur; j < nums.length; j++) {
                swap(nums, cur, j);
                doPermute(cur + 1, nums);
                swap(nums, cur, j);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
