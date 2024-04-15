package com.yangfan.leetcode.datastructures.matrix;

/**
 * 48. Rotate Image
 * 旋转图像
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 */
public class Rotate_Image {
    class Solution {
        public void rotate(int[][] matrix) {
            // 获取矩阵的大小
            int n = matrix.length;
            // 遍历矩阵的上层和左列（直到对角线）
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    // 临时存储matrix[i][j]的值
                    int temp = matrix[i][j];
                    // 将matrix[n - j - 1][i]的值（原矩阵的左下角）赋给matrix[i][j]（原矩阵的左上角）
                    matrix[i][j] = matrix[n - j - 1][i];
                    // 将matrix[n - i - 1][n - j - 1]的值（原矩阵的右下角）赋给matrix[n - j - 1][i]（原矩阵的左下角）
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    // 将matrix[j][n - i - 1]的值（原矩阵的右上角）赋给matrix[n - i - 1][n - j - 1]（原矩阵的右下角）
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    // 将临时存储的值（原matrix[i][j]的值）赋给matrix[j][n - i - 1]（原矩阵的右上角）
                    matrix[j][n - i - 1] = temp;
                }
            }
        }
    }
}
