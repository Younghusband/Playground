package com.yangfan.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * 括号生成
 *
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 */
public class Generate_Parentheses {

    StringBuilder sb = new StringBuilder();
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        // 启动回溯算法，从0个开括号和闭括号开始
        backtrack(0, 0, n);
        return ans;
    }

    private void backtrack(int open, int close, int max) {
        // 如果当前字符串长度等于最大长度的两倍（每对括号占用两个字符位置）
        if (sb.length() == max * 2) {
            ans.add(sb.toString());
            return;
        }
        // 如果开括号的数量小于max，还可以添加开括号
        if (open < max) {
            sb.append("(");
            backtrack(open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);

            // backtrack(current + "(", open + 1, close, max); // 一行搞定撤回
        }
        // 如果闭括号的数量小于开括号的数量，可以添加闭括号
        if (close < open) {
            sb.append(")");
            backtrack(open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
