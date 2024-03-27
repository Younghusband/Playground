package com.yangfan.leetcode.algorithms.greedy;


/**
 * 55. Jump Game
 * 跳跃游戏
 *
 * 这道题我愿称之为，你甭管那么多直接跳！
 *
 * 贪心的思路是，每一步都判断该步最远可达，并更新最远可达值，判断是否能达到数组末端
 */
public class Jump_Game {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0; // 目前能够到达的最远位置

        for (int i = 0; i < n; ++i) {
            // 如果当前位置可以到达
            if (i <= rightmost) {
                // 更新能够到达的最远位置
                rightmost = Math.max(rightmost, i + nums[i]);
                // 如果最远位置已经到达或超过数组的末尾
                if (rightmost >= n - 1) {
                    return true; // 可以到达数组的末尾
                }
            }
        }
        return false;
    }

}
