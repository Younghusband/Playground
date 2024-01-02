package com.yangfan.playground.xjb.algorithm.sort;

import com.yangfan.playground.util.ArrayUtil;

/*********************************************
 * 快速排序
 * 优点: 内部排序，无额外空间需求
 * 缺点: 是不稳定的排序，可能会改变相同大小元素的初始相对位置。
 *
 ********************************************/

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
		sort(arr);
		System.out.println("\n>>>>>>>>>>>>>>>>>排序后的数组>>>>>>>>>>>>>>>>>");
		ArrayUtil.printArray(arr);
	}

	public static void sort(int[] arr) {
		process(arr, 0, arr.length - 1);
	}

	/**
	 * 递归实体
	 */
	public static void process(int[] array, int left, int right) {
		if (left < right) {
			int index = partition(array, left, right);
			process(array, left, index - 1); // 子流程不包含基准值的处理
			process(array, index + 1, right);
		}
	}


	public static int partition(int[] array, int left, int right) {
		// 固定的切分方式
		int key = array[left];
		while (right > left) {
			while (array[right] >= key && right > left) {// 从后半部分向前扫描 直到找到右侧小于基准数停止
				right--;
			}
			array[left] = array[right]; // 交换hi的值给lo
			while (array[left] <= key && right > left) {// 从前半部分向后扫描
				left++;
			}
			array[right] = array[left]; // 交换lo的值给hi
		}
		array[right] = key;
		return right;
	}

}
