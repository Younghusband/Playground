package com.yangfan.leetcode.algorithms.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * 全排列 2
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 和全排列的区别就在于，取值的数组有重复值，但是结果不能有重复值
 *
 * 1. 数组要排序
 * 2. 要判断上一个相同的值是否被加入
 *
 * 该代码可以用于普通全排列的AC。
 */
public class Permutations_II {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean [] visited = new boolean[nums.length];
        Arrays.sort(nums); // 这步很关键
        bt(visited, nums);
        return ans;
    }

    void bt(boolean [] visited, int [] nums) {
        if(path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            // 当前元素已被访问
            // 前一个相同元素没被访问
            if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            bt(visited, nums);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

}
