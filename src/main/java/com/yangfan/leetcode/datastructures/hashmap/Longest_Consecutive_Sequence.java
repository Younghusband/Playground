package com.yangfan.leetcode.datastructures.hashmap;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 128. Longest Consecutive Sequence
 * 最长连续序列
 * 给定一个未排序的整数数组nums
 * 找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 核心: 判断连续。
 * 使用Set或者map来存储，然后通过这个来判断是否存在连续值
 */
public class Longest_Consecutive_Sequence {


    public static void main(String[] args) {
        int [] arr = {100,4,200,1,3,2};
        Arrays.sort(arr);
        for(Integer num : arr) {
            System.out.print(num + " ");
        }
        Longest_Consecutive_Sequence service = new Longest_Consecutive_Sequence();
        service.longestConsecutive(arr);
    }


    /**
     * O(n)
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            // 只有当 num-1 不在集合中时，才以 num 为起点
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;

                // 向后寻找连续的数字
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }

                maxLen = Math.max(maxLen, currentLen);
            }
        }
        return maxLen;
    }


    /**
     * O(nlogn)
     */
    public int my(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int count = 0;
        int max = Integer.MIN_VALUE;
        Integer pre = null;
        for(Integer num : set) {
            if(pre == null) {
                count++;
            } else {
                if(num - pre == 1) {
                    count++;
                } else {
                    count = 1;
                }
            }
            pre = num;
            max = Math.max(max, count);
        }
        return max != Integer.MIN_VALUE ? max : 0;
    }


}
