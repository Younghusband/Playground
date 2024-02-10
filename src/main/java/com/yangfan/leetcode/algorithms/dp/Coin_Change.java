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
 */
public class Coin_Change {

    int [] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1]; // 0 ~ amount
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    int dp(int [] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo[amount] != -666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            int sub = dp(coins, amount - coin);
            if(sub == -1) continue;
            res = Math.min(res, sub + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }


    /**
     * 自底向上的动态规划
     * 使用了动态规划的典型方法，
     * 通过迭代计算从1到amount每个金额所需的最少硬币数，并存储在dp数组中。
     * 这种方法是自底向上的，确保了在计算任何dp[i]值之前，
     * 所有较小的金额值已经被计算并存储。
     */
    public int brute(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }




}
