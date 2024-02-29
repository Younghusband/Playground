package com.yangfan.leetcode.datastructures.arrays;

import com.yangfan.playground.util.StringUtil;

import java.util.Arrays;

/************************************************
 * 88. Merge Sorted Array
 * 合并两个有序数组
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * 首先理解问题的本质， 给定nums1.length = m + n
 * m仅仅是nums1的有效位数  这样就理解了
 *
 * 我感觉这个题目主要的还是学习一下较为常用的工具
 * System.arraycopy(复制源, 源起始下标，目标数组，源终止下标，复制长度);
 *
**************************************************/
public class Merge_Sorted_Array {
	
	public static void main(String[] args) {
		int [] nums1 = {1,3,5,10,11,0,0,0,0};
		int [] nums2 = {2,4,5,6};
		merge1(nums1, 5, nums2, nums2.length);
		StringUtil.printDigitArray("->", nums1);
	}
	
	/**
	 * 首先理解问题的本质， 给定nums1.length = m + n
	 * m仅仅是nums1的有效位数  这样就理解了
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i > -1 && j > -1)
			nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
		while (j > -1)
			nums1[k--] = nums2[j--];
	}

	public static void merge1(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}


}
