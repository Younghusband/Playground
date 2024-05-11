package com.yangfan.leetcode.algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels
 * 划分字母区间
 *
 * 给你一个字符串s。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。

 * 示例 2：
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 *
 *
 * 说是贪心，但实际执行起来是双指针。
 * 贪心的贪字体现在:
 * 由于同一个字母只能出现在同一个片段，显然同一个字母的第一次出现的下标位置和最后一次出现的下标位置必须出现在同一个片段。
 *
 */
public class Partition_Labels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList();

        int [] location = new int[26];
        // 记录每个字母出现的最远位置
        for(int i = 0; i < s.length(); i++) {
            location[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, location[s.charAt(i) - 'a']);
            if(i == end) {
                result.add(end - start + 1); // 加入这段长度
                start = end + 1;
            }
        }
        return result;
    }


}
