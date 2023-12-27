package com.yangfan.playground.xjb.algorithm.sort;

import com.yangfan.playground.util.StringUtil;

/*********************************************
 * InsertionSort.java
 * Author: Vermouth.yf
 * Created on: 2017-8-16
 *
 * Details: 
 * 
 * 插入排序
 * 
 * 插入排序是在一个已经有序的小序列的基础上，一次插入一个元素。当然，刚开始这个有序的小序列只有1个元素，就是第一个元素。
 * 比较是从有序序列的末尾开始，也就是想要插入的元素和已经有序的最大者开始比起，如果比它大则直接插入在其后面，
 * 否则一直往前找直到找到它该插入的位置。如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。
 * 所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的。
 * 
 ********************************************/

public class InsertionSort {
    
	public static void main(String[] args) {
		int [] arr = {6,3,4,2,1,7,9,8,5};
		insertSort(arr);
        StringUtil.printDigitArray(", ", arr);
	}

    public static void insertSort(int [] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;
            //如果arr[i] 大于等于某个前半部分的值 此次插入结束
            while(j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];  // 延迟交换
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
