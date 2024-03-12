package com.yangfan.leetcode.datastructures.arrays;

import java.util.Arrays;

/**
 * 350. Intersection of Two Arrays II
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays
 * and you may return the result in any order.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 */
public class Intersection_of_Two_Arrays_II {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] intersection = new int[Math.min(len1, len2)];
        int p1 = 0, p2 = 0, index = 0;
        while (p1 < len1 && p2 < len2) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                intersection[index] = nums1[p1];
                p1++;
                p2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

//    public int[] intersect(int [] nums1, int[] nums2) {
//
//    }

}
