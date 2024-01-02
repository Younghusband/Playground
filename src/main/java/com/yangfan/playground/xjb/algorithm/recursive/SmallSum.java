package com.yangfan.playground.xjb.algorithm.recursive;

/**
 * 小和问题
 * 问题描述:
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。
 * 比如数组[1,3,4,2,5]，在1左边比1小的数，没有；
 * 在3左边比3小的数，1；
 * 在4左边比4小的数，1、3；
 * 在2左边比2小的数，1；
 * 在5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 */
public class SmallSum {

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(smallSum(arr));
    }

    public static int smallSum(int[] arr) {
        if(arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    /**
     * 理解一下最后一句
     * 组内部分不产生小和，组间产生小和
     */
    public static int process (int[] arr, int left, int right) {
        if(left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid)
                + process(arr, mid + 1, right)
                + merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1]; // 辅助数组
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int sum = 0;
        while(p1 <= mid && p2 <= right) {
            sum += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0; // 与归并排序的区别，这里多了一个计算小和的逻辑
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while(p2 <= right) {
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return sum;
    }


}
