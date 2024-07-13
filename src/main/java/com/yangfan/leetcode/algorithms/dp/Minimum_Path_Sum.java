package com.yangfan.leetcode.algorithms.dp;

/**
 * 64. Minimum Path Sum
 * 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 62题理解了，这题就是顺带做出来的
 *
 * updated. 2024.05.12 难点其实在初始化第一行第一列数值上，以及一维动态规划的压缩上
 */
public class Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {
        // return twoDP(grid);
        return oneDP(grid);
    }

    /**
     * 二维动态规划
     */
    public int twoDP(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int [][] dp = new int[row][col];

        dp[0][0] = grid[0][0];
        // 初始化第一行第一列路径和
        for(int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for(int j = 1; j < row; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
     * 一维动态规划压缩
     */
    public int oneDP(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int [] dp = new int[col];
        // 初始化第一行的dp
        dp[0] = grid[0][0];
        for(int i = 1; i < col; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for(int i = 1; i < row; i++) {
            dp[0] = dp[0] + grid[i][0]; // 更新每一行开头dp
            int preValue = dp[0];
            for(int j = 1; j < col; j++) {
                // 原dp[j]为头顶一格，就理解了
                dp[j] = Math.min(dp[j], preValue) + grid[i][j];
                preValue = dp[j];
            }
        }
        return dp[col - 1];
    }


}
