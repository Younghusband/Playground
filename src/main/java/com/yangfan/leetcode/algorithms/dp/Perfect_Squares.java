package com.yangfan.leetcode.algorithms.dp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 279. Perfect Squares
 *
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer;
 * in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * 1. 动态规划
 * 2. BFS
 * 3. 四平方和定理
 *
 * 重点掌握前两种
 *
 */
public class Perfect_Squares {

    /**
     * 传统动态规划
     * 状态转移方程: dp[i] = min(dp[i - j * j]) + 1, 1 <= j * j <= i
     */
    public int dp(int n) {
        int [] dp = new int[n + 1]; // 隐含条件 dp[0] = 0
        for(int i = 1; i <= n; i++) {
            int res = Integer.MAX_VALUE; // 为什么放在这里，因为每次都要重新计算
            for(int j = 1; j * j <= i; j++) {
                res = Math.min(res, dp[i - j * j]);
            }
            dp[i] = res + 1;
        }
        return dp[n];
    }

    /**
     * BFS
     * 多叉树，能想到也挺不容易的
     */
    public int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(0);
        visited[0] = true;
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                // 遍历所有可能的完全平方数
                for (int j = 1; j * j <= n; j++) {
                    int next = cur + j * j;
                    if (next > n) {
                        break; // 超出范围，停止当前循环
                    }
                    if (next == n) {
                        return depth; // 找到解
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return depth;
    }


    /**
     * 数学方式
     * 四平方和定理
     * 智力过剩的时候再看
     */
    public int fourSquares(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }

}
