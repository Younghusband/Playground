package com.yangfan.leetcode.algorithms.sorting.fast;


import com.yangfan.playground.util.ArrayUtil;

/**
 * 堆排序
 * 时间复杂度 O(NlogN)
 * 空间复杂度 O(1)
 * 不稳定排序
 * <p>
 * 步骤
 * 1. 构建最大堆
 * 2. 把堆顶弹出放到数组末端，构建新堆，循环直至排序完
 */
public class HeapSort {

    public static void main(String[] args) {
        int [] arr = {9,3,2,1,5,6,18,7,-4};
//        int [] arr = {-4,0,7,4,9,-5,-1,0,-7,-1};
        sort(arr);
        ArrayUtil.printArray(arr);
    }

    public static void sort(int[] arr) {


    }


}
