package com.yangfan.leetcode.algorithms.greedy;

import java.util.Arrays;

/**
 * 135. Candy
 * 分发糖果
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目。
 *
 * 示例 1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 *
 * 示例 2：
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 * 1. 先从左往右发
 * 2. 再从右往左修正
 */
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        // 每个孩子至少一颗糖果
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // 初始每个孩子分到至少一颗糖果

        // 从左向右遍历，确保每个孩子与其左边的孩子比较后糖果数满足条件
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // 从右向左遍历，确保每个孩子与其右边的孩子比较后糖果数满足条件
        // 整个代码的核心
        for (int i = n - 2; i >= 0; i--) {
            // 如果当前孩子评分比右边孩子高
            if (ratings[i] > ratings[i + 1]) {
                // 同时确保不减少当前孩子已有的糖果数（保证第一次遍历的结果）
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        // 累加所有孩子的糖果数得到结果
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }

}
