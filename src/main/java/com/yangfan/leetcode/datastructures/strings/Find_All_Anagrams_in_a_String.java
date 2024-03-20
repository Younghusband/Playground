package com.yangfan.leetcode.datastructures.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * 找到字符串中所有字母异位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * 这道题的核心不是滑动窗口，
 * 滑动窗口不是难点，难点在于字符串的匹配细节。
 *
 */
public class Find_All_Anagrams_in_a_String {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if(sLen < pLen) {
            return result;
        }
        byte [] sCount = new byte[26];
        byte [] pCount = new byte[26];
        for(int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++; // 仅需这么遍历一次
        }

        for(int i = 0; i < sLen - pLen + 1; i++) {
            if(i != 0) {
                // 减去左字母
                sCount[s.charAt(i - 1) - 'a']--;
                // 加上右字母
                sCount[s.charAt(i + pLen - 1) - 'a']++;
            }
            if(Arrays.equals(sCount, pCount)) {
                result.add(i);
            }
        }
        return result;
    }



}
