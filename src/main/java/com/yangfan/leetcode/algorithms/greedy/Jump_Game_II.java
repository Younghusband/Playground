package com.yangfan.leetcode.algorithms.greedy;

/**
 * 45. Jump Game II
 * 跳跃游戏 II
 *
 * 相对于Jump Game，这道题是要求最少的跳跃次数
 * 我愿称之为，你先别跳，先看看你能跳多远！
 *
 */
public class Jump_Game_II {

    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0; // 当前跳跃能够到达的最远位置
        int maxPosition = 0; // 下一次跳跃能够到达的最远位置
        int steps = 0;

        // 不需要遍历最后一个元素，因为到达最后一个元素时不需要再跳跃
        for (int i = 0; i < n - 1; ++i) {
            // 更新下一次跳跃能够到达的最远位置
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 如果当前位置到达了当前跳跃能够到达的最远位置
            if (i == end) {
                // 更新当前跳跃能够到达的最远位置为下一次跳跃能够到达的最远位置
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


}
