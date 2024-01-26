package com.yangfan.leetcode.daily;


import java.util.List;

/**
 * 2865. Beautiful Towers I
 * 题目描述太过于啰嗦，直接不贴了
 * https://leetcode.cn/problems/beautiful-towers-i/description/
 *
 *
 * 1. 数组暴力循环
 * 2. 单调栈
 *
 */
public class Beautiful_Towers_I {

    public static void main(String[] args) {
        Beautiful_Towers_I beautiful_towers_i = new Beautiful_Towers_I();
        System.out.println(beautiful_towers_i.maximumSumOfHeights(List.of(1, 2, 3, 4, 5)));
        System.out.println(beautiful_towers_i.maximumSumOfHeights(List.of(5, 4, 3, 2, 1)));
        System.out.println(beautiful_towers_i.maximumSumOfHeights(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println(beautiful_towers_i.maximumSumOfHeights(List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)));
        System.out.println(beautiful_towers_i.maximumSumOfHeights(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 99)));
        System.out.println(beautiful_towers_i.maximumSumOfHeights(List.of(99, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)));
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long res = 0;
        for (int i = 0; i < n; i++) {
            int pre = maxHeights.get(i);
            long sum = pre;
            for (int j = i - 1; j >= 0; j--) {
                pre = Math.min(pre, maxHeights.get(j));
                sum += pre;
            }
            int suf = maxHeights.get(i);
            for (int j = i + 1; j < n; j++) {
                suf = Math.min(suf, maxHeights.get(j));
                sum += suf;
            }
            res = Math.max(res, sum);
        }
        return res;
    }




}
