package com.yangfan.leetcode.datastructures.arrays;


/**
 * 2765. Longest Alternating Subarray
 *
 * 最长交替子数组
 *
 * Input: nums = [2,3,4,3,4]
 * Output: 4
 * Explanation: The alternating subarrays are [3,4], [3,4,3], and [3,4,3,4].
 * The longest of these is [3,4,3,4], which is of length 4.
 *
 * nums[i] - nums[firstIndex]  == (length - 1) % 2
 * 这才是关键，不然按照我那个判断就麻烦死了
 */
public class Longest_Alternating_Subarray {

    public static void main(String[] args) {
        // [31,32,31,32,33]
        int [] nums = {31,32,31,32,33};
        Longest_Alternating_Subarray la = new Longest_Alternating_Subarray();
        System.out.println(la.alternatingSubarray(nums));
    }


    /**
     * O(n)
     */
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        int n = nums.length;
        int firstIndex = 0;
        for (int i = 1; i < n; i++) {
            int length = i - firstIndex + 1;
            // 符合升降升降规则
            if (nums[i] - nums[firstIndex] == (length - 1) % 2) {
                res = Math.max(res, length);
            }
            // 打破规则
            else {
                // 如果升，重新开启统计
                if (nums[i] - nums[i - 1] == 1) {
                    firstIndex = i - 1;
                    res = Math.max(res, 2);
                } else {
                    firstIndex = i;
                }
            }
        }
        return res;
    }

    /**
     * 我的蠢方法
     * 虽蠢但O(n)
     */
    public int my(int[] nums) {
        int max = -1;
        boolean exceptDown = false;
        int count = -1;
        for(int i = 0; i < nums.length - 1; i++) {
            int factor = nums[i + 1] - nums[i];
            // 实际上升1
            if(factor == 1) {
                // 计划下降
                if(exceptDown) {
                    max = Math.max(max, count);
                    count = 2;
                } else {
                    if(count == -1) {
                        count = 2;
                    } else {
                        count ++;
                        max = Math.max(max, count);
                    }
                }
                exceptDown = true;
            }
            // 实际下降1
            else if(factor == -1) {
                // 计划下降
                if(exceptDown) {
                    count ++;
                    max = Math.max(max, count);
                    exceptDown = false;
                } else {
                    max = Math.max(max, count);
                    count = -1;
                }
            }
            // 退出情况
            else {
                max = Math.max(max, count);
                count = -1;
            }
            if(i == nums.length - 2)
                max = Math.max(max, count);
        }
        return max;
    }


}
