package com.yangfan.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * 组合
 * Given two integers n and k,
 * return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 *
 * 无序，不重复
 */
public class Combinations {

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> data = combinations.combine(4, 2);
        System.out.println(data);
    }

    /**
     * 为了让回溯方法里干净些
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    /**
     * 数据范围 1-n
     * 选择k个数进行组合
     */
    public List<List<Integer>> combine(int n, int k) {
        backTrack(1, n, k);
        return ans;
    }

    void backTrack(int start, int n, int limit) {
        if(path.size() == limit) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= n; i++) {
            path.add(i);
            backTrack(i + 1, n, limit);
            path.remove(path.size() - 1);
        }
    }


}
