package com.yangfan.leetcode.algorithms.dp;

import java.util.Arrays;

/**
 * 62. Unique Paths
 * 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 注意不能走回头路，所以凹形之类的路线是不可能出现的。
 * 不能走回头路这个也可以用来奠定动态规划的初始值
 *
 * 1. 二维数组法
 * 2. 一维数组法，一维的比较难想，不要求
 *
 */
public class Unique_Paths {

    /**
     * 传统的二维动态规划做法
     */
    public int uniquePaths(int m, int n) {
        // dp数组的含义是 dp[i][j] 代表着走到{i, j} 这个方格一共有多少种方法
        int[][] dp = new int[m][n];
        // 初始化第一行和第一列为1，因为机器人只能向右或向下移动，到达这些位置的路径只有一条
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 从第二行第二列开始递推计算路径数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 到达当前位置的路径数等于到达上方格子和左侧格子的路径数之和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 逻辑压缩
     * dp数组代表具体列的行径数
     * 然后在每一行都更新一遍，更新到最后一行后返回该列值即可
     *
     * 比较难想的点也包括 dp[j] += dp[j - 1]; 这个动态转移方程
     */
    public int uniquePathsPro(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }


    /**
     * 数学方法
     * 从左上角到右下角的过程中，我们需要移动 m+n−2m+n-2m+n−2 次，
     * 其中有 m−1m-1m−1 次向下移动，n−1n-1n−1 次向右移动。
     * 因此路径的总数，就等于从 m+n−2m+n-2m+n−2 次移动中选择 m−1m-1m−1 次向下移动的方案数，即组合数
     *
     */
    public int uniquePathsByMath(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }





}
