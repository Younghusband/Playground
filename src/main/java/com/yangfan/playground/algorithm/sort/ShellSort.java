package com.yangfan.playground.algorithm.sort;

import com.yangfan.playground.util.ArrayUtil;

/**
 * @author mr_yo
 * 
 * Invented by Donald Shell
 */
public class ShellSort {
    
    public static void main(String[] args) {
        int [] arr= {9,3,2,1,5,6,8,7,4};
        shellSort(arr);
        ArrayUtil.printArray(arr);
    }
    
    
    
    /**
     * @param arr
     * @return
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        int temp, gap = len / 2;
        while(gap > 0) {
            for (int i=gap; i< len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }
    

}
