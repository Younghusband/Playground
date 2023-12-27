package com.yangfan.playground.xjb.algorithm.sort;

import com.yangfan.playground.util.ArrayUtil;

import java.util.*;

/*********************************************
 * QuickSort.java
 * Author: Vermouth.yf
 * Created on: 2017-8-21
 *
 * Details:   快速排序
 *            不稳定，可能会改变相同大小元素的初始相对位置。
 *            
 ********************************************/

public class QuickSort {

	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
		sort.quickSort(arr);
		System.out.println("\n>>>>>>>>>>>>>>>>>排序后的数组>>>>>>>>>>>>>>>>>");
		ArrayUtil.printArray(arr);
	}

	public void quickSort(int[] arr) {
		sort(arr, 0, arr.length - 1);  //调用方式类似 Arrays.sort
	}

	/**
	 * 递归实体
	 */
	public void sort(int[] array, int lo, int hi) {
		if (lo < hi) {
			int index = partition(array, lo, hi);
			sort(array, lo, index - 1);
			sort(array, index + 1, hi);   //先排左边先排右边无所谓
		}
	}


	public int partition(int[] array, int lo, int hi) {
		// 固定的切分方式
		int key = array[lo];
		while (hi > lo) {
			while (array[hi] >= key && hi > lo) {// 从后半部分向前扫描 直到找到右侧小于基准数停止
				hi--;
			}
			array[lo] = array[hi]; // 交换hi的值给lo
			while (array[lo] <= key && hi > lo) {// 从前半部分向后扫描
				lo++;
			}
			array[hi] = array[lo]; // 交换lo的值给hi
		}
		array[hi] = key;
		return hi;
	}

}
