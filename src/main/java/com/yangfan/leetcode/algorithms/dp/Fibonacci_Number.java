package com.yangfan.leetcode.algorithms.dp;

/**
 * 509. Fibonacci Number
 * 斐波那契数
 *
 * f(0) = 0, f(1) = 1
 *
 * 1. 记忆化搜索
 * 2. 动态规划
 */
public class Fibonacci_Number {

    /**
     * 标准动归
     */
    public int standardDP(int n) {
        if(n <= 1) return n;
        int dp [] = new int [n + 1];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    /**
     * 虽然没有dp数组，但可以理解为是动态规划
     */
    public int fib(int n) {
        if(n <= 1) return n;
        int p0 = 0;
        int p1 = 1;
        int sum = 0;
        for(int i = 2; i <= n; i++) {
            sum = p0 + p1;
            p0 = p1;
            p1 = sum;
        }
        return sum;
    }



    /**
     * dfs + memo
     */
    public int dfsWithMemo(int n) {
        int[] memo = new int[n + 1];
        return d(n, memo);
    }

    int d(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return n; // 直接返回n
        }
        if (memo[n] > 0) // 检查memo[n]是否已经计算过
            return memo[n];

        int res = d(n - 2, memo) + d(n - 1, memo);
        memo[n] = res; // 将计算结果存储在memo中
        return res;
    }

}
