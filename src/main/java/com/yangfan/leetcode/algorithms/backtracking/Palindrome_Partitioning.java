package com.yangfan.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * 分割回文串
 * Given a string s, partition s such that every substring
 * of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 */
public class Palindrome_Partitioning {

    public static void main(String[] args) {
        String xxx = "apple";
        System.out.println(xxx.substring(0));
        System.out.println(xxx.substring(0, 2));
    }

    List<List<String>> result = new ArrayList<>();
    List<String> current = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(0, s);
        return result;
    }

    private void backtrack(int start, String s) {
        if (start == s.length()) { // 刚好越界
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // 如果当前子串是回文，则添加到当前分割方案
                current.add(s.substring(start, end + 1));
                // 继续尝试对剩余字符串进行分割
                backtrack(end + 1, s);
                // 回溯，撤销当前子串的选择
                current.remove(current.size() - 1);
            }
        }
    }

    // 检查子串 s[left...right] 是否是回文
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
