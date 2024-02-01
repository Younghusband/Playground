package com.yangfan.leetcode.datastructures.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */

public class Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters x = new Longest_Substring_Without_Repeating_Characters();
        String s = "tmmzuxt";
        System.out.println(x.lengthOfLongestSubstring(s));

    }

    /**
     * 利用hashMap 瞬间定位子串中重复字符出现的位置，
     * 并将i = location+1
     *
     * 其中 "a...a" 这种类型是个陷阱，需要 判断重复元素的下标是否大于当前left
     * 如果left大，则取left ...
     **/
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> helper = new HashMap<>();
        while (right < len) {
            char cur = s.charAt(right);
            if (helper.containsKey(cur)) {
                // 如果重复字符在left身后就不管，如果
                left = Math.max(left, helper.get(cur) + 1);
            }
            helper.put(cur, right);
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }

    /**
     * 我的方法的问题就在于，map的remove操作是多余的
     */
    public int my(String s) {
        char [] chs = s.toCharArray();
        int len = chs.length;
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> helper = new HashMap();
        while(right < len) {
            // 未出现重复 right++
            char cur = chs[right];
            if(!helper.containsKey(cur)) {
                max = Math.max(right - left + 1, max);
            } else {
                // abcdd
                int repeatIndex = helper.get(cur);
                left = repeatIndex + 1;
                // 清理掉 [0, repeatIndex]的值
                removeRange(helper, 0, repeatIndex);
            }
            helper.put(cur, right);
            right++;
        }
        return max;
    }

    void removeRange(Map<Character, Integer> map, int start, int end) {
        map.entrySet().removeIf(entry -> entry.getValue() >= start && entry.getValue() <= end);
    }


}
