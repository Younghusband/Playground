package com.yangfan.leetcode.datastructures.hashmap;

import java.util.*;

/**
 * 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 */
public class Group_Anagrams {

    public static void main(String[] args) {
        String [] xxx = {"eat","tea","tan","ate","nat","bat"};
        Group_Anagrams service = new Group_Anagrams();
        System.out.println(service.my(xxx));
    }

    /**
     * 优雅的hashmap标准解法, 仅需遍历一次
     * 省去了记录下标的过程，直接记录字符串结果
     * key: orderedStr  value: 收集的字符串
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
//            String sortedStr = reSort(str);
            String sortedStr = countSort(str);
            List<String> strList = map.getOrDefault(sortedStr, new ArrayList<>());
            strList.add(str);
            map.put(sortedStr, strList); // getOrDefault方式创建的value，需要重新put回去
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 我的垃圾解法
     * 1. 遍历得到 orderedStr -> 下标数组
     * 2. 遍历map 根据下标数组 获得各list
     *
     * 3.12自己再做一遍的时候，发现我当时的解法还行。。
     */
    public List<List<String>> my(String[] strs) {
        List<List<String>> result = new ArrayList();
        Map<String, List<Integer>> strIndexArrMap = new HashMap();
        for(int i = 0; i < strs.length; i++) {
            String reOrderedStr = reSort(strs[i]);
            List<Integer> indexes = strIndexArrMap.getOrDefault(reOrderedStr, new ArrayList<>());
            indexes.add(i);
            strIndexArrMap.put(reOrderedStr, indexes);
        }

        // 根据map的值进行结果组装
        for(Map.Entry<String, List<Integer>> entry : strIndexArrMap.entrySet()) {
            List<String> ana = new ArrayList<>();
            List<Integer> indexes = entry.getValue();
            for(int index: indexes) {
                ana.add(strs[index]);
            }
            result.add(ana);
        }
        return result;
    }

    String reSort(String origin) {
        char [] charArray = origin.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    String countSort(String str) {
        int[] counts = new int[26];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            counts[str.charAt(i) - 'a']++;
        }
        // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                sb.append((char) ('a' + i));
                sb.append(counts[i]); // 有创意的
            }
        }
        return sb.toString();
    }

}
