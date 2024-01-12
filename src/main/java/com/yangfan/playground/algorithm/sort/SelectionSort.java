package com.yangfan.playground.algorithm.sort;

import com.yangfan.playground.util.StringUtil;

/*********************************************
 * SelectionSort.java
 * Author: Vermouth.yf
 * Created on: 2017-8-16
 *  选择排序:  选择的是位置上的元素，而不是元素本身
 * 
 *  举个例子，序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，
 *  所以选择排序不是一个稳定的排序算法。
 *
 * 每轮记录下标， 将每轮的第一个元素和下标元素进行交换，然后进行下一轮
 * 
 ********************************************/

public class SelectionSort {  
	
	public static void main(String[] args) {
	    int [] arr= {9,3,2,1,5,6,8,7,4};
	    selectionSort(arr);
        StringUtil.printDigitArray(", ", arr);
	}
	
    public static void selectionSort(int[] arr) {
        int location;
        for (int i = 0; i < arr.length - 1; i++) {
            location = i;
            for (int j = i + 1; j < arr.length; j++) { // 每一轮记录选择最小元素的下标
                if (arr[j] < arr[location]) { // 与记录的最小值进行比较，并视情况更新最小值的下标
                    location = j;
                }
            }
            // swap
            if(location != i) {
                arr[i] = arr[i] + arr[location];
                arr[location] = arr[i] - arr[location];
                arr[i] = arr[i] - arr[location];
            }
        }
    }
	
}
