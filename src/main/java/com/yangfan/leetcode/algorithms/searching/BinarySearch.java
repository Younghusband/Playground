package com.yangfan.leetcode.algorithms.searching;

/**
 *  #704 Binary Search
 *
 * 二分查找
 *
 * 1.  mid = (hi+lo)/2  这样有溢出风险
 * 2.  更新lo和hi的时候用mid会有死循环风险  不过我暂时没有 模拟出来
 * 3.  如果一直没找到，也可以通过不停移动lo和hi来逼近坐标。  所以hi==lo的情况必须加入到循环条件里面。
 * 
 */

public class BinarySearch {

	/**
	 * 临界值是核心点
	 * l <= r
	 */
	public int search(int[] nums, int target) {
		int mid = 0;
		int l = 0;
		int r = nums.length - 1;
		while(l <= r) {
			mid = (l + r) >>> 1;
			if(target == nums[mid]) {
				return mid;
			} else if(target > nums[mid]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

	
	public int binaryS(int[]arr, int key, int l, int r){
		if(l > r) return -1;
		int mid = (r+l) >>> 1; //  l + (r - l) / 2
		if(key == arr[mid]) {
			return mid;
		} else if(key > arr[mid]) {
			return binaryS(arr, key,mid+1, r);
		} else {
			return binaryS(arr, key, l,mid-1);
		}
	}

	

}
