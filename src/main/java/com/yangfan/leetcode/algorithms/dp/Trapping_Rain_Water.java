package com.yangfan.leetcode.algorithms.dp;

/**
 * 42. Trapping Rain Water
 * 接雨水
 *
 * 动态规划：动态规划方法是通过计算每个位置左侧的最高高度和右侧的最高高度，
 * 然后利用这些信息来确定每个位置上可以接的雨水量。
 * 这种方法直观地反映了接雨水的本质，即每个位置上可以接的雨水量取决于该位置左右两侧的最高高度。
 *
 * 双指针：双指针方法是一种优化的动态规划，它使用两个指针从两端向中间遍历，动态地维护左侧最高高度和右侧最高高度，
 * 并在遍历过程中计算每个位置可以接的雨水量。这种方法减少了空间复杂度，并且避免了动态规划中的重复计算。
 *
 * 单调栈：单调栈方法是通过维护一个递减栈来找到每个位置左侧和右侧第一个比它高的位置，
 * 从而确定每个位置可以接的雨水量。这种方法更加关注于局部的凹槽结构，利用栈来寻找每个位置的接水边界。
 */
public class Trapping_Rain_Water {

    public int useTwoPoint(int [] height) {
        int ans = 0; // 存储最终能接的雨水总量
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            // 更新左右最大高度
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

//    public int useDp(int[] height) {
//
//    }
//
//    public int useStack(int [] height) {
//
//    }



}
