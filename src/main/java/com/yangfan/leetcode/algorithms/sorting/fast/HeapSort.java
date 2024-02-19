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
        System.out.println(1/2 - 1);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        // 构建最大堆 i初始值[n/2 - 1, n - 1] 都是可以的
        // n/2 - 1是最后一个非叶子节点
        for(int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // 将堆顶元素弹出
        for(int i = n - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }


    static void heapify(int [] nums, int i, int heapSize) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if(left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if(right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        // 如果最大值不是根节点，递归
        if(largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
            heapify(nums, largest, heapSize);
        }
    }


}
