package com.yangfan.leetcode.algorithms.sorting.fast;

import com.yangfan.playground.util.ArrayUtil;

public class QuickSortPro {

    public static void main(String[] args) {
        QuickSortPro service = new QuickSortPro();
        int[] arr = {5,2,3,1};
        service.quickSort(arr);
        System.out.println(">>>>>>>>>>>>>>>>>超级快排后的数组>>>>>>>>>>>>>>>>>");
        ArrayUtil.printArray(arr);
    }

    /**
     * 超级快排>>>>>>>>>>>>>>>>>>>
     */
    public void quickSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        quickProcess(arr, 0, arr.length - 1);
    }

    public void quickProcess(int[] arr, int L, int R) {
        if(L < R) {
            // int强转相当于向下取整，[0, R-L+1) -> [0, R-L]
            swap(arr, L + (int)(Math.random() * (R -L + 1)), L);  // 交换L和[L, R]范围内的随机位置
            int[] p = partitionPro(arr, L, R);
            quickProcess(arr, L, p[0] - 1); // < 区
            quickProcess(arr, p[1] + 1, R); // > 区
        }
    }

    /**
     * 默认以arr[r]做划分，p = arr[r]。数组按 <p ==p >p 三段划分
     * 返回数组等于区域的[左边界，右边界]
     *
     * 关于less，L，more 三个指针的变化
     * 直接参考 @see Sort_Colors.java
     * 三色国旗算法
     */
    public int[] partitionPro(int[] arr, int L, int R) {
        int less = L - 1; // <区右边界
        int more = R + 1; // >区左边界
        int p = arr[L];
        int cur = L;
        // 注意终止条件，是游标触及右边界
        while(cur < more) {
            if(arr[cur] < p) {
                swap(arr, ++less, cur++);
            } else if(arr[cur] > p) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[] {less + 1, more - 1};
    }

    private void swap(int[] arr, int L, int R) {
        ArrayUtil.swap(arr, L, R);
    }

}
