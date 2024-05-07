package com.yangfan.leetcode.algorithms.searching;

/**
 * 74. Search a 2D Matrix
 * 搜索二维矩阵
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 解法有很多，但总结一下无非两类
 * 1. 转化为一维数组进行二分处理
 * 2. 先定位行，再定位具体位置。定位行列的过程中分别都可以进行二分
 *
 * 不要局限于二分的“二”，快速逼近都可以叫做二分
 *
 */
public class Search_a_2D_Matrix {


    /**
     * 这个解法的核心有两个
     * 1. 初始位置的选择很重要，为什么能想到选择右上角作为起始位置
     * 2. 二分不要局限于求中点，任何趋近于结果的快速逼近都可以叫做二分
     *
     * 其思路为先锁定行，然后逐步逼近具体的位置
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0, j = col - 1; // 定位右上角作为搜索起点
        // 不要越界
        while(i < row && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                i++; // 最大值小于目标，换到下一行
            } else {
                j--; // 锁定行，收缩
            }
        }
        return false;
    }



    /**
     * 我的最常规的思路
     * 1. 把二维数组转化为一维数组
     * 2. 对一维数组进行常规二分查找
     */
    public boolean my(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int [] arr = new int[row * col];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                arr[i * col + j] = matrix[i][j];
            }
        }
        return binarySearch(arr, target) != -1;
    }

    int binarySearch(int [] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + right >>> 1;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


}
