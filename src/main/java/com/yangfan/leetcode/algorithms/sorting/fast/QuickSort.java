package com.yangfan.leetcode.algorithms.sorting.fast;

import com.yangfan.playground.util.ArrayUtil;

/*********************************************
 * 快速排序
 * 优点: 内部排序，无额外空间需求
 * 缺点: 1. 容易因为不合适的基准值使得排序时间复杂度升至O(n^2)
 *      2. 是不稳定的排序，可能会改变相同大小元素的初始相对位置。
 *
 *
 * 快速排序Pro(荷兰国旗算法，是快排进阶优化的前置知识。)
 * 优化了上面的缺点1，每次基准值选择是随机的，概率上使得时间复杂度为O(NlogN)
 *
 *
 ********************************************/

public class QuickSort {

	public static void main(String[] args) {
		QuickSort service = new QuickSort();
		int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
		service.sort(arr);
		System.out.println(">>>>>>>>>>>>>>>>>普通快排后的数组>>>>>>>>>>>>>>>>>");
		ArrayUtil.printArray(arr);
	}

	/**
	 * 普通快排>>>>>>>>>>>>>>>>>>>
	 */
	public void sort(int[] arr) {
		process(arr, 0, arr.length - 1);
	}

	public void process(int[] arr, int left, int right) {
		if (left < right) {
			swap(arr, left + (int)(Math.random() * (right -left + 1)), left);
			int pivot = partition(arr, left, right);
			process(arr, left, pivot - 1); // 子流程不包含基准值的处理
			process(arr, pivot + 1, right);
		}
	}

	/**
	 * 传统的Hoare划分, LeetCode上速度更快
	 */
	public int partition(int[] arr, int left, int right) {
		int p = arr[left]; // 把基准值保存下来，以免交换过程中丢失
		while (left < right) {
			while (left < right && arr[right] >= p) {// 从后半部分向前扫描 直到找到右侧小于基准数停止
				right--;
			}
			arr[left] = arr[right]; // 小于基准值的数通过覆盖的方式放在左边
			while (left < right && arr[left] <= p) {// 从前半部分向后扫描
				left++;
			}
			arr[right] = arr[left]; // 大于基准值的数通过覆盖的方式放在右边
		}
		arr[right] = p;  // 此时left和right是相等的，返回谁都可以
		return right;
	}

	private void swap(int[] arr, int L, int R) {
		ArrayUtil.swap(arr, L, R);
	}

}
