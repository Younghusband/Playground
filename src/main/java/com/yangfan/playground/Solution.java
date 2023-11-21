package com.yangfan.playground;

import com.yangfan.playground.util.ArrayUtil;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    
    public static void main(String[] args) {

        // 声明一个数组，用于冒泡排序
        int [] arr = ArrayUtil.createRandomArray(10,50, 0.01);
        // 打印数组arr
        System.out.println("排序前：");
        ArrayUtil.printArray(arr);
        // 冒泡排序
        bubbleSort(arr);
        System.out.println("排序后：");
        ArrayUtil.printArray(arr);


    }

    public static void bubbleSort(int [] arr)  {
        for(int i = 0; i < arr.length-1; i++) {
            boolean hasSwap = false;
            for(int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    hasSwap = true;
                    ArrayUtil.swap(arr, j, j+1);
                }
            }
            if(!hasSwap) {
                System.out.println("第" + (i+1) + "次遍历后，没有发生交换，排序提前结束");
                break;
            }
        }
    }
    
}
