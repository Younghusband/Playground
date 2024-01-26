package com.yangfan.leetcode.algorithms.sorting.slow;

import com.yangfan.playground.util.StringUtil;

/*********************************************
 *  选择排序
 *  选择的是位置上的元素，而不是元素本身
 * 
 *  举个例子，序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，
 *  所以选择排序不是一个稳定的排序算法。
 *
 *  每轮将有序区的最后一个元素和无序区最小元素进行交换，然后进行下一轮
 *
 *  核心点: 记录下标，每轮结束再交换，减少交换次数
 * 
 ********************************************/

public class SelectionSort {  
	
	public static void main(String[] args) {
	    int [] arr= {9,3,2,1,5,6,8,7,4};
	    selectionSort(arr);
        StringUtil.printDigitArray(", ", arr);
	}
	
    public static void selectionSort(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            // 从有序区的下一个元素开始，每一轮记录最小元素的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) { // 与记录的最小值进行比较，并更新最小值的下标
                    minIndex = j;
                }
            }
            // swap
            if(minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
	
}
