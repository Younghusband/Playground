package com.yangfan.leetcode.algorithms.dp;


/**
 * 518. Coin Change 2
 * 零钱兑换 II
 *
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 示例 1：
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 */
public class Coin_Change_II {

    /**
     *  完全背包问题
     */
    public int change(int amount, int[] coins) {
        int [] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin: coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }




}
