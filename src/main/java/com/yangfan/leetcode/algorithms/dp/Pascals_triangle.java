package com.yangfan.leetcode.algorithms.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's triangle
 * 杨辉三角
 *
 *    1
 *   1 1
 *  1 2 1
 * 1 3 3 1
 * ...
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 注意点:
 * 两层for循环的边界条件
 */
public class Pascals_triangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 每行首尾
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

}
