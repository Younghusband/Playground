package com.yangfan.leetcode.algorithms.dp;


import java.util.HashMap;
import java.util.Map;

/**
 * 70. Climbing Stairs
 *
 * You are climbing a staircase.
 * It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 *
 * 官方题解有点变态，忽视即可
 */
public class Climbing_Stairs {

    /**
     * 标准解法
     */
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int sum = 0;
        int p1 = 1, p2 = 2;
        for(int i = 3; i <= n; i++) {
            sum = p1 + p2;
            p1 = p2;
            p2 = sum;
        }
        return sum;
    }

    /**
     * 最简单的思路，
     * 虽然剪枝了，但是仍会超时
     */
    public int digui(int n) {
        Map<Integer, Integer> helper = new HashMap<>();
        return dp(helper, n);
    }

    public int dp(Map<Integer, Integer> helper, int n) {
        if(n == 1 || n == 2) {
            helper.put(n, n);
            return n;
        }
        if(helper.containsKey(n)) return helper.get(n);
        return dp(helper,n - 2) + dp(helper,n - 1);
    }

    /**
     * 看看就好
     */
    public int newbee(int n){
        int x = 1, y = 1;
        for(; n-- > 0 ;) {
            y = y + x; // sum
            x = y - x; // y -> x
        }
        return x;
    }


}
