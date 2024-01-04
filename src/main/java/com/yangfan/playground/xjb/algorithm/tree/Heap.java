package com.yangfan.playground.xjb.algorithm.tree;

import com.yangfan.playground.util.ArrayUtil;

/**
 * 堆的相关操作
 *
 * 1. 插入堆
 * 2. 重新调整堆
 *
 * 如果试图在堆的某个index插入一个数，只会出现两种情况。
 * 如果该新数大于index上已有的值 ? 执行heapInsert操作 : 执行heapify操作
 *
 */
public class Heap {

    /**
     * heapInsert 是由堆底至堆顶向上的过程
     * 某个数处于index位置，继续往上移动
     */
    public static void heapInsert(int[] arr, int index) {
        int parentIndex = (index - 1) / 2;
        // 如果该节点大于父节点
        while(arr[index] > arr[parentIndex]) {
            ArrayUtil.swap(arr, index, parentIndex);
            index = parentIndex;
        }
    }

    /**
     * heapify 是由堆顶至堆底向下的过程
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; // 左孩子的下标
        while(left < heapSize) { // 仍有孩子节点
            // 俩孩子中，谁大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 父与子中较大的进行比较，谁大，把下标给largest
            largest = arr[largest] < arr[index] ? index : largest;
            if(largest == index) {
                break;  // 这里的大前提是，数据整体符合堆的性质。不然如果孙子节点
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr , int index1, int index2) {
        ArrayUtil.swap(arr, index1, index2);
    }



}
