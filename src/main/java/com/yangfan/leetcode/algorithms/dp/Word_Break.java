package com.yangfan.leetcode.algorithms.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 *
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented
 * into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class Word_Break {

    public boolean wordBreak(String s, List<String> wordDict) {
        // 使用 HashSet 来存储词典，便于快速查找
        Set<String> wordDictSet = new HashSet(wordDict);
        // 创建动态规划表 dp，其中 dp[i] 表示字符串 s 的前 i 个字符能否被完全分解
        boolean[] dp = new boolean[s.length() + 1];

        // 初始化 dp[0] 为 true，表示空字符串可以被分解（基础情况）
        dp[0] = true;

        // 主循环，遍历字符串 s 的所有字符
        for (int i = 1; i <= s.length(); i++) {
            // 内循环，尝试将字符串分割为两部分：s[0:j] 和 s[j:i]
            for (int j = 0; j < i; j++) {
                // 检查前半部分 s[0:j] 是否可被分解（dp[j] 为 true）
                // 同时后半部分 s[j:i] 是否存在于词典中
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    // 如果找到这样的 j，使得 s[0:i] 可以被分解，设置 dp[i] 为 true 并结束当前循环
                    dp[i] = true;
                    break;
                }
            }
        }
        // 返回字符串 s 的全部字符是否可以被分解
        return dp[s.length()];
    }


}
