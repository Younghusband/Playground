package com.yangfan.playground.algorithm.sort;

import com.yangfan.playground.util.ArrayUtil;

/**
 * @description 
 *   将两个有序数组进行合并  是 归并排序的众多操作的最后一步
 *   
 *   在这里我们先研究如何将两个有序数组合并为一个有序数组
 *  
 * @author vermouth.Mac
 * @version 2017年2月28日 下午10:21:08
 */

public class Merge2SortedArray {

	public static void main(String[] args) {
		int [] arr1 = {3, 6, 7, 9, 10, 15};
		int [] arr2 = {1, 4, 8, 11, 12};
		ArrayUtil.printArray(sortArrPro(arr1, arr2));
	}
	
	/**
	 * 更简洁，少了一个临时变量
	 * */
	public static int[] sortArrPro(int[] arr1, int[] arr2) {
		int[] array = new int[arr1.length + arr2.length];
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {  //两个数组都完整的时候出不了这个循环
			array[i + j] = arr1[i] < arr1[j] ? arr1[i++] : arr2[j++];
		}
		while (i < arr1.length) {  //数组1还没耗尽
			array[i + j] = arr1[i++];
		}
		while (j < arr2.length) {  //数组2还没耗尽
			array[i + j] = arr2[j++];
		}
		return array;
	}
	
}
