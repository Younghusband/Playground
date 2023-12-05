package com.yangfan.playground.xjb.algorithm.sort;

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
		print(arr);
	}


	public int partion(int[] array, int lo, int hi) {
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

	/**
     * 递归实体
     */
	public void sort(int[] array, int lo, int hi) {
		if (lo < hi) {
			int index = partion(array, lo, hi);
			sort(array, lo, index - 1);
			sort(array, index + 1, hi);   //先排左边先排右边无所谓
		}
	}

	public void quickSort(int[] arr) {
		sort(arr, 0, arr.length - 1);  //调用方式类似 Arrays.sort
	}


	/**
	 * Author: Vermouth.yf 
	 * Date: 2017-8-21 
	 * @param nums   数组大小
	 * @param min    数组最小值
	 * @param max    数组最大值
	 * @return
	 */
	public static int[] generateRandom(int nums, int min, int max) {
		int[] arr = new int[nums];  //初始化如此之大的数组
		Random ran = new Random();
		for (int i = 0; arr[arr.length - 1] == 0; i++) {
			int temp = ran.nextInt(max);
			boolean flag = false;
			if (temp >= min && temp <= max) {
				flag = !flag;   //为了降低无用操作
			}
			if (flag) {  //校验元素是否在数组中已经存在,如果存在 继续下一次循环
				checkAndAdd(arr, temp);
			}
		}
		System.out.println("生成的随机数数组:");
		for (int i : arr)
			System.out.print(i + "->");
		return arr;
	}
	
	
	/**
	 * 检查数组中是否已有该target, 有则不作任何操作，无则加到数组末尾
	 * 从头遍历到尾,遇到0就赋值并break. 遇到等于target的值直接break
	 * @param arr
	 * @param target
	 */
	public static void checkAndAdd(int[] arr, int target) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = target;
				index = i;
				System.out.println("在第" + (index + 1) + "个位置上插入了随机数。");
				break;
			}
			if (arr[i] == target) {
				break;
			}
		}
	}
	
	public static void print(int [] arr){
		System.out.println("\n>>>>>>>>>>>>>>>>>排序后的数组>>>>>>>>>>>>>>>>>");
		for(int i: arr)
			   System.out.print(i+"->");	
        System.out.print("\n");
	}

}
