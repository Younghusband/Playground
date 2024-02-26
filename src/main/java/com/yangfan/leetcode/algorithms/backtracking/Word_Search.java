package com.yangfan.leetcode.algorithms.backtracking;

/**
 * 79. Word Search
 * 单词搜索
 *
 * 给定一个m x n二维字符网格board和一个字符串单词word 。
 * 如果word存在于网格中，返回true; 否则，返回false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 * 基础问题:
 * 1. 如何在矩阵里回溯搜索
 * 2. 如何判断是否越界
 * 3. 如何判断是否已经访问过
 * 4. 如何判断当前位置的字符是否与单词中对应的字符不匹配
 * 5. 如何标记当前位置为已访问
 * 6. 如何撤销当前位置的访问标记
 * 7. 如何递归地在当前位置的上、下、左、右四个方向尝试搜索剩余的单词部分
 * 8. 如何判断是否已经匹配了单词
 *
 */
public class Word_Search {

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // 遍历二维数组的每个位置，尝试从每个位置开始搜索单词
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果从当前位置开始可以搜索到单词，则返回true
                if (backtrack(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int row, int col, String word, int index, boolean[][] visited) {
        // 如果当前已匹配的字符长度等于单词长度，说明单词已经完全匹配，返回true
        if (index == word.length()) return true;
        // 检查当前位置是否越界或者当前位置的字符是否与单词中对应的字符不匹配，或者已经被访问过
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (visited[row][col] || board[row][col] != word.charAt(index)) return false;

        // 标记当前位置为已访问
        visited[row][col] = true;
        // 递归地在当前位置的上、下、左、右四个方向尝试搜索剩余的单词部分
        if (backtrack(board, row - 1, col, word, index + 1, visited) ||
                backtrack(board, row + 1, col, word, index + 1, visited) ||
                backtrack(board, row, col - 1, word, index + 1, visited) ||
                backtrack(board, row, col + 1, word, index + 1, visited)) {
            return true; // 如果四个方向中的任意一个方向能匹配剩余的单词部分，则返回true
        }

        // 如果当前位置的四个方向都不能匹配剩余的单词部分，则撤销当前位置的访问标记（回溯）
        visited[row][col] = false;
        return false; // 返回false，继续尝试其他的路径
    }


}
