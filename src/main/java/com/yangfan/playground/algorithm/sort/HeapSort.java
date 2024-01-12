package com.yangfan.playground.algorithm.sort;


import com.yangfan.playground.util.ArrayUtil;
import com.yangfan.playground.algorithm.tree.Heap;

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
        int [] arr = {9,3,2,1,5,6,8,7,4};
        sort(arr);
        ArrayUtil.printArray(arr);
    }


    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int heapSize = arr.length;
        // 构建最大堆
        for (int i = 0; i < arr.length; i++) { // O(N)
            Heap.heapInsert(arr, i); // O(logN)
        }
        // 首次将最大堆顶弹出，放置于数组末端，堆大小-1
        Heap.swap(arr, 0, --heapSize);
        while(heapSize > 0) {   // O(N)
            // 按照新的大小，重新构建堆
            Heap.heapify(arr, 0, heapSize); // O(logN)
            Heap.swap(arr, 0, --heapSize); // O(1)
        }
    }



}
