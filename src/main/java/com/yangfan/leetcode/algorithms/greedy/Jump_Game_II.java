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
        int jumps = 0;
        int targetPos = 0; // 当前跳跃能到达的最远距离
        int farthest = 0; // 遍历过程中能到达的最远位置

        // 不包括最后一个元素，因为到达最后一个元素后无需再跳跃
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // 走到之前设定的最远目标
            if (i == targetPos) {
                jumps++;
                targetPos = farthest; // 更新目标
                // 如果当前的最远距离已经可以到达数组的最后一个位置，则直接结束循环
                if (targetPos >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps; // 返回跳跃次数
    }


}
