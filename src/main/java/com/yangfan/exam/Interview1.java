package com.yangfan.exam;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 */
public class Interview1 {

    public static void main(String[] args) {
        String xxx = "abcabcbb";
        System.out.println(maxLen(xxx));
    }


    public static int maxLen(String s) {
        if(s == null) return 0;
        int len = s.length();
        if(len <= 1) return len;
        // 字符对应的下标
        Map<Character, Integer> helper = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(helper.containsKey(c)) {
                // 判断重复字符串和左指针的相对位置，更新左指针
                left = Math.max(left, helper.get(c) + 1);
            }
            helper.put(c, i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }




}
