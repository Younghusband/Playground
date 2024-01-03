package com.yangfan.playground.xjb.algorithm.tree;

import com.yangfan.playground.util.ArrayUtil;

/**
 *
 */
public class Heap {


    // 某个数处于index位置，继续往上移动
    public static void heapInsert(int[] arr, int index) {
        int parentIndex = (index - 1) / 2;
        // 如果该节点大于父节点
        while(arr[index] > arr[parentIndex]) {
            ArrayUtil.swap(arr, index, parentIndex);
            index = parentIndex;
        }
    }



}
