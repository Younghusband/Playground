package com.yangfan.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * 组合总和
 *
 * 给你一个无重复元素的整数数组candidates和一个目标整数target,
 * 找出candidates中可以使数字和为目标数target的所有不同组合,
 * 并以列表形式返回。你可以按任意顺序返回这些组合。
 * candidates中的同一个数字可以无限制重复被选取。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 */
public class Combination_Sum {

    public static void main(String[] args) {
        Combination_Sum service = new Combination_Sum();
        int [] arr = {2, 5, 3};
        int target = 7;
        List<List<Integer>> ans = service.combinationSum(arr, target);
        System.out.println(ans);
    }

    List<Integer> combo = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, candidates, target);
        return ans;
    }

    public void dfs(int start, int[] candidates, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(combo));
            return;
        } else if(target > 0){
            for(int i = start; i < candidates.length; i++) {
                combo.add(candidates[i]);
                dfs(i, candidates, target - candidates[i]);
                combo.remove(combo.size() - 1);
            }
        }
    }


}
