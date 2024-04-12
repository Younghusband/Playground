package com.yangfan.exam;

import java.util.Scanner;

/**
 * 用于考试
 *
 * 第一行输入m和n，m代表村子的土地的长，n代表土地的宽
 * 第二行开始输入地图上的具体标识
 *
 * 输出需要分配的土地面积，即包含相同数字旗子的最小矩阵中的最大面积。
 * 旗子上的数字为1-500，土地边长不超过500
 * 未插旗子的土地用0标识
 *
 * 3 3
 * 1 0 1
 * 0 0 0
 * 0 1 0
 * 输出 9
 *
 * 3 3
 * 1 0 2
 * 0 0 0
 * 0 3 4
 *
 */
public class MainCopy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); // 行
        int n = sc.nextInt(); // 列

        // 初始化辅助数据结构
        int [] exist = new int[501]; // 存储0 - 500
        int [] minRow = new int[501];
        int [] maxRow = new int[501];
        int [] minCol = new int[501];
        int [] maxCol = new int[501];
        for(int i = 0; i < 500; i++) {
            minRow[i] = 666;
            minCol[i] = 777;
            maxRow[i] = -666;
            maxCol[i] = -777;
        }

        // 矩阵输入
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int cur = sc.nextInt();
                exist[cur] = 1;
                maxRow[cur] = Math.max(i, maxRow[cur]);
                minRow[cur] = Math.min(i, minRow[cur]);
                maxCol[cur] = Math.max(j, maxCol[cur]);
                minCol[cur] = Math.min(j, minCol[cur]);
            }
        }

        // 面积计算
        int result = 0;
        for(int i = 0; i < exist.length; i++) {
            int num = exist[i];
            if(num == 1) {
                int len = maxRow[i] - minRow[i] + 1;
                int width = maxCol[i] - minCol[i] + 1;
                int currentArea = len * width;
                result = Math.max(result, currentArea);
            }
        }
        System.out.println(result);
    }


}
