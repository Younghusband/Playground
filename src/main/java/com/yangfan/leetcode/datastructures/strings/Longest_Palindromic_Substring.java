package com.yangfan.leetcode.datastructures.strings;


/**
 * 5. Longest Palindromic Substring
 * 最长回文子串
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * 非常经典的字符串操作题目，要求找出字符串中最长的回文子串。
 *
 * 1. 暴力           √
 * 2. 多维动态规划    √
 * 3. 中心扩展
 * 4. Manacher算法
 *
 * 不管怎样，至少暴力要做到每次都能写出来
 *
 */
public class Longest_Palindromic_Substring {

    /**
     * 动态规划的基本思想是：
     *
     * 定义状态：定义一个二维数组 dp[i][j]，其中 dp[i][j] 表示从索引 i 到索引 j 的子串是否是回文。
     * 状态转移方程：
     * 如果 s[i] == s[j]，那么 dp[i][j] 的值取决于 dp[i+1][j-1]（即如果 s[i+1] 到 s[j-1] 是回文，那么 s[i] 到 s[j] 也是回文）。
     * 特殊情况是，当子字符串长度为 1 或 2 时，如果 s[i] == s[j]，那么 dp[i][j] 应直接设为真。
     * 初始化：
     * 所有单个字符都是回文，所以对于所有 i，dp[i][i] 都是真。
     * 如果两个连续字符相同，那么 dp[i][i+1] 也是真。
     * 目标：找到 dp[i][j] 为真且 j-i+1（长度）最大的 i 和 j。
     *
     * 时间复杂度O(n^2)
     * 空间复杂度O(n^2)
     */
    public String dp(String s) {
        int n = s.length();
        if(n < 2) return s;
        int start = 0;
        int maxLen = 1;
        boolean [][] dp = new boolean[n][n];
        // 初始化dp数组
        // 长度为1的子串
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 长度为2的子串
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        // 长度大于等于3的子串
        for(int len = 3; len <= n; len++) {
            for(int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                // 状态转移方程
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }


    /**
     * 虽然是暴力解法，但是剪枝处处蕴含着技巧
     * 1. 长度不够提前退出外循环
     * 2. 内循环每次按照最长子串的步长来移动
     * 3. 头尾比较，窗口大小和子串长度比较等
     *
     */
    public String brute(String s) {
        if(s.length() == 1) return s;
        int len = s.length();
        String subStr = s.substring(0, 1); // 初始子串
        for(int left = 0; left < s.length(); left++) {
            if(left + subStr.length() >= len) break; // 最长回文子串后续不可能产生
            for(int right = left + subStr.length(); right < s.length(); right++) {
                // 头尾相同 滑动窗口大于子串长度 才进行回文判断
                if(s.charAt(left) == s.charAt(right)
                        && right - left + 1 > subStr.length()
                        && checkP(s, left, right)) {
                    subStr = s.substring(left, right + 1);
                }
            }
        }
        return subStr;
    }

    boolean checkP(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }


}
