package com.yangfan.leetcode.datastructures.stack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 * 反转每对括号间的子串
 *
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 *
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 解释：先反转子字符串 "love" ，然后反转整个字符串。
 *
 * 1. 栈
 * 2. 跳转遍历法 (了解即可)
 *
 */
public class Reverse_Substrings_Between_Each_Pair_of_Parentheses {

    public String reverseParentheses(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder(); // 当前正在构建的字符串
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 遇到左括号，将当前字符串压栈，并重置当前字符串
                stack.push(curr.toString());
                curr.setLength(0);
            } else if (c == ')') {
                // 遇到右括号，完成当前括号内字符串的反转
                curr.reverse();
                // 将栈顶保存的之前的字符串作为头部拼接反转后的字符串
                curr.insert(0, stack.pop());
            } else {
                // 添加普通字符到当前字符串
                curr.append(c);
            }
        }
        return curr.toString();
    }

    /**
     * 遇到括号就跳转，然后转向
     */
    public String cleverSolution(String s) {
        int n = s.length();
        int [] pairIndex = new int[n];
        // 仅用于存储遇到的左括号位置
        Deque<Integer> stack = new ArrayDeque<>();
        // 每对括号的匹配位置
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pairIndex[i] = j;
                pairIndex[j] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0, step = 1; // 初始方向向右
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pairIndex[index]; // 跳转到匹配的括号位置
                step = -step; // 反转遍历方向
            } else {
                sb.append(s.charAt(index));
            }
            index += step; // 移动到下一个字符
        }
        return sb.toString();
    }


}
