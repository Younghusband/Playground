package com.yangfan.leetcode.algorithms.dp;

import java.util.Arrays;

/**
 * 322. Coin Change
 * 零钱兑换
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * updated 2024.04.25
 *
 *
 */
public class Coin_Change {


    /**
     * 自底向上的动态规划
     * 使用了动态规划的典型方法，
     * 通过迭代计算从1到amount每个金额所需的最少硬币数，并存储在dp数组中。
     * 这种方法是自底向上的，确保了在计算任何dp[i]值之前，
     * 所有较小的金额值已经被计算并存储。
     */
    public int dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;  // 注意这俩顺序
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    // memo数组用于存储每个amount的最优解（最少硬币数量）
    int [] memo;

    public int coinChange(int[] coins, int amount) {
        // 初始化memo数组，长度为amount + 1，因为要包括从0到amount每个值的解
        memo = new int[amount + 1];
        Arrays.fill(memo, -666); // 使用特殊值-666标记未计算过的状态
        return dfs(coins, amount);
    }

    /**
     * 自顶向下
     */
    int dfs(int [] coins, int amount) {
        // 基准情况：当amount为0时，不需要硬币，返回0
        if(amount == 0) return 0;
        // 如果amount小于0，表示当前组合不可行，返回-1
        if(amount < 0) return -1;
        // 如果当前amount的解已经被计算过，直接返回存储的解
        if(memo[amount] != -666) {
            return memo[amount];
        }
        // 初始化最少硬币数量为Integer.MAX_VALUE，便于后续寻找最小值
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            // 计算减去当前硬币值后的剩余金额的最优解
            int sub = dp(coins, amount - coin);
            // 如果子问题无解，则跳过
            if(sub == -1) continue; // 核心
            // 更新最少硬币数量
            res = Math.min(res, sub + 1);
        }
        // 如果res未被更新，说明没有可行解，将memo[amount]标记为-1；否则，存储并返回最少硬币数量
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }


}
