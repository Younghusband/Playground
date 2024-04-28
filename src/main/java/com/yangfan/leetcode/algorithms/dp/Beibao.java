package com.yangfan.leetcode.algorithms.dp;

/**
 * 来源于华为面试
 *
 *  注意：每种物品只能选一次，不考虑包的空间大小。
 *
 *  现场有N个物品和Mary的背包最多只能装S千克的物品；
 *  N个正整数Wi(0 < Wi ≤ 100)，表示每个物品的重量(单位千克)。
 *
 *  判断背包能否被装满
 */
public class Beibao {

    public static boolean canFillBag(int[] weights, int maxWeight) {
        boolean[] dp = new boolean[maxWeight + 1];
        dp[0] = true; // 初始化dp[0]为true，表示零容量可以不装任何物品即为"装满"
        // weight在外层，说明了其有限
        for (int weight : weights) {
            for (int j = maxWeight; j >= weight; j--) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        return dp[maxWeight]; // 如果dp[maxWeight]为true，表示可以装满
    }

}
