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
     * 轮数为单词数，每轮比较后得到一个新单词，如果单词长度大于0，继续比较，否则结束循环直接返回空字符串
     */
    public String horizontalScan(String [] strs) {
        String preStr = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            int minLen = Math.min(preStr.length(), strs[i].length());
            while(j < minLen) {
                if(preStr.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j++; // 相等的情况下才递进
            }
            if(j == 0) return ""; // 提前退出逻辑: 没有公共前缀
            preStr = preStr.substring(0, j);
        }
        return preStr;
    }

    /**
     * 我这属于纵向扫描
     */
    public String verticalScan(String [] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];  // 如果数组只有一个字符串，直接返回

        int minLen = Integer.MAX_VALUE;
        for (String item : strs) {
            if (item == null || item.isEmpty()) return "";  // 处理空字符串或null元素
            minLen = Math.min(minLen, item.length());
        }

        StringBuilder longestPrefix = new StringBuilder();
        for (int p = 0; p < minLen; p++) {
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


}
