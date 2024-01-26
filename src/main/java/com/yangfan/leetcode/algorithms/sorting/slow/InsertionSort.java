package com.yangfan.leetcode.algorithms.sorting.slow;

import com.yangfan.playground.util.StringUtil;

/*********************************************
 * 插入排序
 * 
 * 插入排序是在一个已经有序的小序列的基础上，一次插入一个元素。
 * 当然，刚开始这个有序的小序列只有1个元素，就是第一个元素。
 * 比较是从有序序列的末尾开始，也就是想要插入的元素和已经有序的最大者开始比起，如果比它大则直接插入在其后面，
 * 否则一直往前找直到找到它该插入的位置。
 * 如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。(稳定排序的前提)
 * 
 ********************************************/

public class InsertionSort {
    
	public static void main(String[] args) {
		int [] arr = {6,3,4,2,1,7,9,8,5};
		insertSort(arr);
        StringUtil.printDigitArray(", ", arr);
	}

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            // 找到 key 应该插入的位置
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j]; // 将比 key 大的元素向右移动
                j--;
            }
            // 原来j的位置插入key
            arr[j + 1] = key;
        }
    }


}
