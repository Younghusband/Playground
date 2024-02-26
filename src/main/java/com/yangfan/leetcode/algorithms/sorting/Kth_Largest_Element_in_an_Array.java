package com.yangfan.leetcode.algorithms.sorting;

/**
 * 215. Kth Largest Element in an Array
 * 数组中的第k个最大元素
 *
 * 与放在《堆》章节的不同，这里采用传统排序获得答案
 *
 * 1. 冒泡排序，冒到第k轮之后结束，并返回nums[len - k]
 * 2. 选择排序，每次选最大的元素放在左侧，选k个后结束，并返回nums[k - 1]
 * 3. 插入排序，正常排序完成后选择nums[len - k]
 *            倒序排序完后选择nums[k - 1]
 *
 * 这样来看，除了插入排序，其他两个排序都可以不用完全排序后就得到top-k。
 * 插入排序需要完全进行完毕之后才能得到具体顺次的值。
 */
public class Kth_Largest_Element_in_an_Array {

    /**
     * 冒第k个泡
     */
    public int bubble(int[] nums, int k) {
        int len = nums.length;
        for(int i = 0; i < k; i++) {
            boolean hasSwap = false;
            for(int j = 0; j < len -i - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    hasSwap = true;
                    swap(nums, j, j + 1);
                }
            }
            if(!hasSwap) {
                break;
            }
        }
        return nums[len - k];
    }

    /**
     * 选第k个数
     */
    public int select(int[] nums, int k) {
        int len = nums.length;
        for(int i = 0; i < k; i++) {
            int largestIndex = i;
            for(int j = i + 1; j < len; j++) {
                if(nums[j] > nums[largestIndex]) {
                    largestIndex = j;
                }
            }
            if(largestIndex != i) {
                swap(nums, i, largestIndex);
            }
        }
        return nums[k - 1];
    }

    /**
     * 插入必须得排完...
     */
    public int insert(int[] nums, int k) {
        int len = nums.length;
        if(len == 1) return nums[0];
        for(int i = 1; i < len; i++) {
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] < key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }

        return nums[k - 1]; // 倒序
        // return nums[len - k]; // 正序
    }



    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
