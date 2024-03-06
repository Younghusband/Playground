package com.yangfan.leetcode.datastructures.strings;

/**
 * 1614. Maximum Nesting Depth of the Parentheses
 * 括号的最大嵌套深度
 *
 * 不要看题目的描述
 * 示例：
 * 输入：s = "(1)+((2))+(((3)))"
 * 输出：3
 *
 */
public class Maximum_Nesting_Depth_of_the_Parentheses {

    public int maxDepth(String s) {
        int result = 0, count = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                count++;
                result = Math.max(count, result);
            }
            if(c == ')') {
                count--;
            }
        }
        return result;
    }

}
