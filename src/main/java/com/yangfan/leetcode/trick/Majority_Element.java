package com.yangfan.leetcode.trick;

import java.util.Arrays;
import java.util.Random;

/**
 * 169. Majority Element
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 * 属于脑筋急转弯题
 * 如果数组中存在这种元素，那么排序后的数组中间的元素一定是这个元素
 *
 */
public class Majority_Element {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        Majority_Element me = new Majority_Element();
        System.out.println(me.my(nums));
    }

    /**
     * 1. 标准解法
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 2. 摩尔投票算法（Boyer-Moore Voting Algorithm）
     */
    public int mooreVoting(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    /**
     * 3. 瞎猫碰死耗子随机算法
     */
    public int luckyOrNot(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length / 2; // 定义多数元素的出现次数阈值

        while (true) {
            // 随机选择数组中的一个元素作为候选
            int candidate = nums[randRange(rand, 0, nums.length)];
            // 如果这个候选元素的出现次数超过了多数元素的定义，则返回这个元素
            if (countOccurrences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    private int randRange(Random rand, int min, int max) {
        // 生成一个在[min, max)范围内的随机整数
        return rand.nextInt(max - min) + min;
    }

    private int countOccurrences(int[] nums, int key) {
        int count = 0;
        // 遍历数组，统计元素key的出现次数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                count++;
            }
        }
        return count;
    }

    /**
     * 4. 自己的废柴解法
     */
    public int my(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 1; i < len; i++) {
            if(nums[i] != nums[i - 1])
                count = 1;
            else
                count++;
            if(count > (len / 2))
                return nums[i];
        }
        return nums[0];
    }

}
