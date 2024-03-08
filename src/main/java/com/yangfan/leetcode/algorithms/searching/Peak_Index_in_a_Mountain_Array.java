package com.yangfan.leetcode.algorithms.searching;


/**
 * 852. Peak Index in a Mountain Array
 * 山脉数组的峰顶索引
 *
 * 具有特征的数据，利用数据的特征
 * 峰值左侧递增，右侧递减
 *
 */
public class Peak_Index_in_a_Mountain_Array {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid; // 怕mid就是峰顶
            }
        }
        return left;
    }


    public int brute(int[] arr) {
        int n = arr.length;
        int ans = -1;
        for (int i = 1; i < n - 1; ++i) {
            // 遇到递减了，就是峰顶
            if (arr[i] > arr[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }


}
