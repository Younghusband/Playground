package com.yangfan.leetcode.algorithms.sorting;

import com.yangfan.leetcode.algorithms.sorting.fast.MergeSort;
import com.yangfan.leetcode.algorithms.sorting.fast.QuickSort;
import com.yangfan.leetcode.algorithms.sorting.slow.BubbleSort;
import com.yangfan.leetcode.algorithms.sorting.slow.InsertionSort;
import com.yangfan.playground.util.ArrayUtil;

/**
 * 对数器
 * 用于测试排序算法的正确性
 */
public class SortTester {

    private static final int TEST_TIME = 500_000;
    private static final int ARRAY_MAX_SIZE = 100;
    private static final int ARRAY_MAX_VALUE = 100;

    public static void main(String[] args) {

        testWithSpecificAlgorithm(InsertionSort::insertSort);
        testWithSpecificAlgorithm(BubbleSort::bubble);
        testWithSpecificAlgorithm(arr -> new MergeSort().sort(arr));
        testWithSpecificAlgorithm(arr -> new QuickSort().sort(arr));
    }

    public static void testWithSpecificAlgorithm(SortAlgorithm sortAlgorithm) {
        test(TEST_TIME, ARRAY_MAX_SIZE, ARRAY_MAX_VALUE, sortAlgorithm);
    }

    public static void test(int testTime, int maxSize, int maxValue, SortAlgorithm sortAlgorithm) {
        boolean succeed = true;
        for(int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            // 待测试排序
            sortAlgorithm.sort(arr1);
            // 对比组
            ArrayUtil.sort(arr2);
            if(!ArrayUtil.isEqual(arr1, arr2)) {
                ArrayUtil.printArray(arr1);
                ArrayUtil.printArray(arr2);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }


}
