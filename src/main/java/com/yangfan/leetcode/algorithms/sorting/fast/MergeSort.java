package com.yangfan.leetcode.algorithms.sorting.fast;

import com.yangfan.playground.util.ArrayUtil;

/**
 * 归并排序
 * 递归实现 与 非递归实现
 * 优点: 稳定排序
 * 缺点: 外部排序，需要一个O(n)的辅助空间
 *
 * 延伸一下，归并之所以难不在于排序本身，
 * 而在于归并的思路可以用来出很多道题，比如求小和，比如逆序对
 */

public class MergeSort {
	
	public static void main(String[] args) {
		MergeSort service = new MergeSort();
		int[] array = ArrayUtil.createRandomArray(10, 50, 0.01);
		System.out.print("排序前:\t");
		ArrayUtil.printArray(array);
		service.sort(array);
//		sortRecursive(array);
		System.out.print("排序后:\t");
		ArrayUtil.printArray(array);
	}

	/**
	 * 递归方式
	 */
	public void sort(int [] arr) {
		process(arr, 0, arr.length - 1);
	}


	public void process(int[] arr, int L, int R) {
		if (L < R) {
			int M = (L + R) >>> 1;
			// 左边
			process(arr, L, M);
			// 右边
			process(arr, M + 1, R);  //先排左侧还是先排右侧并无影响
			// 左右归并
			MergeSort.merge(arr, L, M, R);
		}
	}

	/**
	 * 公用的，相邻数组合并方法
	 */
	//将L~M  M+1~R 这两段排序 然后重新赋值进arr
	public static void merge(int [] arr, int L, int M, int R) {
		int p1 = L;       // 第一段数组下标
		int p2 = M + 1;   // 第二段数组下标
		int i = 0;        // 临时数组下标
		int[] help = new int[R - L + 1];  // 临时数组的长度
		while (p1 <= M && p2 <= R) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		// 下面两个while只有可能进入一个
		while (p1 <= M) {  // 后半段用完的情况
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {   // 前半段用完的情况
			help[i++] = arr[p2++];
		}
		// !!!!! 最后要把这个临时数组的值复制到数组中
		for(i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
	}

	//总方法
	public void sortFromBottom(int[] arr) {
		int arrLength = arr.length;
		// 从最小粒度到最大粒度合并
		for (int size = 1; size < arrLength; size = size * 2) {
			int left;
			for (left = 0; left + 2 * size - 1 < arrLength; left += 2 * size) {
				merge(arr, left, left + size - 1, left + 2 * size - 1);   //把相邻两段长度均为size的排序好的数组合并
			}
			//如果剩下一个数组不够gap
			if (left + size - 1 < arrLength) {
				merge(arr, left, left + size - 1, arrLength - 1);
			}
		}
	}

}
