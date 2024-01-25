package com.yangfan.leetcode.datastructures.strings;
/************************************************
 * 14. Longest Common Prefix
 * 最长公共前缀
 *
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 *
 * Example:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * 这题的官方题解可以的。
 * 1. 横向扫描
 * 2. 纵向扫描
 * 3. 分治
 * 4. 二分查找
 *
 **************************************************/
public class Longest_Common_Prefix {

    /**
     * 横向扫描实现
     */



    /**
     * 我这属于纵向扫描
     */
    public String verticalScan(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int maxPossiblePrefixLen = getMinLen(strs);
        StringBuilder longestPrefix = new StringBuilder();
        for (int p = 0; p < maxPossiblePrefixLen; p++) {
            char temp = strs[0].charAt(p);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(p) != temp) {
                    return longestPrefix.toString();
                }
            }
            longestPrefix.append(temp);
        }
        return longestPrefix.toString();
    }

    int getMinLen(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String item : strs) {
            minLen = Math.min(minLen, item.length());
        }
        return minLen;
    }



}
