package com.yangfan.playground.xjb.algorithm.sort;

import com.yangfan.playground.util.ArrayUtil;

import java.util.Arrays;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月25日 下午5:56:28
 * 
 * 
 * 用递归来实现归并
 */

public class MergeSortRecur {
	
	public static void main(String[] args) {
		MergeSortRecur user = new MergeSortRecur();
        int [] a = ArrayUtil.createRandomArray(10, 50, 0.01);
		user.mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
		
	}
	
	public void mergeSort(int[] a, int low, int high) {
		MergeSort tool = new MergeSort();
        int mid = (low + high) >>> 1;
        if (low < high) {
        	// 右边
        	mergeSort(a, mid + 1, high);  //先排左侧还是先排右侧并无影响
            // 左边
            mergeSort(a, low, mid);
            // 左右归并
            tool.merge(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }
    }

}
