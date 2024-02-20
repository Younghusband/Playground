package com.yangfan.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
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
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> data = subsets.subsets(nums);
        System.out.println(data);
    }

    // 存储单个子集
    List<Integer> path = new LinkedList();
    // 存储所有子集的集合
    List<List<Integer>> ans = new LinkedList();

    public List<List<Integer>> subsets(int[] nums) {
        bt(0, nums);
        return ans;
    }

    void bt(int start, int[] nums) {
        // 在进入更深层递归前，添加当前路径（子集）的副本到答案中
        ans.add(new LinkedList(path));
        for(int i = start; i < nums.length; i++) {
            // 添加当前元素到路径中
            path.add(nums[i]);
            // 递归探索以当前元素为起点的所有子集
            bt(i + 1, nums);
            // 回溯，移除路径中最后一个元素，以探索其他可能的子集
            path.remove(path.size() - 1);
        }
    }

    /**
     * 数组n个元素
     * 相当于n个位置，取或者不取
     * 每个位置取或者不取，两种选择
     * 最后构成整个数组的所有子集
     */
    private void btPro(int cur, int [] nums) {
        // 当前位置等于数组长度时，说明已经访问完数组中所有元素
        if (cur == nums.length) {
            // 将当前路径（一个完整的子集）添加到答案列表中
            ans.add(new ArrayList(path));
            return;
        }
        // 决策路径一：选择当前元素，加入到当前子集中
        path.add(nums[cur]);
        // 继续向下搜索，考虑下一个元素
        btPro(cur + 1, nums);
        // 回溯到上一个状态，移除刚才加入的当前元素
        path.remove(path.size() - 1);
        // 决策路径二：不选择当前元素，即直接考虑下一个元素
        btPro(cur + 1, nums);
    }




}
