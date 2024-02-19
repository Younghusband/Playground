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
		int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
		sort(arr);
		System.out.println(">>>>>>>>>>>>>>>>>普通快排后的数组>>>>>>>>>>>>>>>>>");
		ArrayUtil.printArray(arr);
//		quickSort(arr);
//		System.out.println(">>>>>>>>>>>>>>>>>超级快排后的数组>>>>>>>>>>>>>>>>>");
//		ArrayUtil.printArray(arr);
	}

	/**
	 * 普通快排>>>>>>>>>>>>>>>>>>>
	 */
	public static void sort(int[] arr) {
		process(arr, 0, arr.length - 1);
	}

	public static void process(int[] arr, int left, int right) {
		if (left < right) {
			swap(arr, left + (int)(Math.random() * (right -left + 1)), right);
			int pivot = partition(arr, left, right);
			process(arr, left, pivot - 1); // 子流程不包含基准值的处理
			process(arr, pivot + 1, right);
		}
	}

	public static int partition(int[] array, int left, int right) {
		int p = array[left]; // 把基准值保存下来，以免交换过程中丢失
		while (right > left) {
			while (array[right] >= p && right > left) {// 从后半部分向前扫描 直到找到右侧小于基准数停止
				right--;
			}
			array[left] = array[right]; // 交换right的值给left
			while (array[left] <= p && right > left) {// 从前半部分向后扫描
				left++;
			}
			array[right] = array[left]; // 交换left的值给right
		}
		array[right] = p;
		return right;
	}

	/**
	 * 超级快排>>>>>>>>>>>>>>>>>>>
	 */
	public static void quickSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		quickProcess(arr, 0, arr.length - 1);
	}

	public static void quickProcess(int[] arr, int L, int R) {
		if(L < R) {
			// int强转相当于向下取整，[0, R-L+1) -> [0, R-L]
			swap(arr, L + (int)(Math.random() * (R -L + 1)), R);  // 交换R和[L, R]范围内的随机位置
			int[] p = partitionPro(arr, L, R);
			quickProcess(arr, L, p[0] - 1); // < 区
			quickProcess(arr, p[1] + 1, R); // > 区
		}
	}

	/**
	 * 默认以arr[r]做划分，p = arr[r]。数组按 <p ==p >p 三段划分
	 * 返回数组等于区域的[左边界，右边界]
	 *
	 * 关于less，L，more 三个指针的变化
	 * 1. 小于基准值的时候，左边界less+1
	 * 2. 小于等于基准值的时候，指针L+1
	 * 3. 大于基准值的时候，指针不会动，右边界-1
	 */
	public static int[] partitionPro(int[] arr, int L, int R) {
		int less = L - 1; // <区右边界
		int more = R; // >区左边界
		// L表示当前数的位置 arr(R)为基准值
		while(L < more) { // 当遍历指针撞上>区边界，结束遍历
			if(arr[L] < arr[R]) { // 当前数 < 基准值p
				swap(arr, ++less, L++); // 左边界向右推进1，并且交换当前数和左边界值，当前数指针+1
			} else if(arr[L] > arr[R]) { // 当前数 > 基准值p
				// 右边界向左推进1，并且交换当前数与右边界值
				swap(arr, --more, L); // 由于当前值现在是新的未审查过，留到下一轮，L保持不变
			} else {
				// 当前值等于基准值，指针+1
				L++;
			}
		}
		swap(arr, more, R); // 把一开始在最右侧的基准值放在 ==p段的最右侧
		return new int[] {less + 1, more}; // 此刻的more对应的是基准值，也就是交换后的==段的最后一个值
	}

	public static void swap(int[] arr, int L, int R) {
		ArrayUtil.swap(arr, L, R);
	}

}
