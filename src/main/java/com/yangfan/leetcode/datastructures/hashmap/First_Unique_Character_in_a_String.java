package com.yangfan.leetcode.datastructures.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * 字符串中的第一个唯一字符
 *
 */
public class First_Unique_Character_in_a_String {

    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new HashMap();
        for(char c : s.toCharArray()) {
            int count = countMap.getOrDefault(c, 0);
            countMap.put(c, count + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            int count = countMap.get(s.charAt(i));
            if(count == 1)
                return i;
        }
        return -1;
    }


}
