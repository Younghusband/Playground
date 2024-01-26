package com.yangfan.leetcode.interview;


import java.util.ArrayList;
import java.util.List;

/**
 *  某次阿里二面
 *  打印ABC全排列
 */

public class ABC {

    public static void main(String[] args) {
        char [] nums = {'A', 'B', 'C'};
        ABC abc = new ABC();
        List<List<Character>> data = abc.permute(nums);
        System.out.println(data);
    }

    List<Character> path = new ArrayList<>();
    List<List<Character>> ans = new ArrayList<>();

    public List<List<Character>> permute(char [] nums) {
        boolean [] used = new boolean[nums.length];
        bt(nums, used);
        return ans;
    }

    void bt(char [] nums, boolean [] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList(path));
            return;
        }

        // 遍历可选元素
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) // 如果上一层决策树用到了该元素，跳过
                continue;
            path.add(nums[i]);
            used[i] = true;
            bt(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


}
