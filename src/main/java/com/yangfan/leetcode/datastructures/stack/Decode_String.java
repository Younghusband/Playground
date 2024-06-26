package com.yangfan.leetcode.datastructures.stack;

import java.util.Stack;


/**
 * 394. Decode String
 * 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 感觉栈的意思就是，先存起来，再处理。
 */
public class Decode_String {

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>(); // 数字栈，用于存放重复的次数
        Stack<StringBuilder> stringStack = new Stack<>(); // 字符串栈，用于存放当前的字符串序列
        StringBuilder currentString = new StringBuilder(); // 当前正在构建的字符串
        int k = 0; // 用于计算括号前的数字
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // 如果是数字，计算整个数字
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // 遇到左括号，将当前数字和字符串推入各自的栈中
                countStack.push(k);
                stringStack.push(currentString);
                // 重置当前字符串和计数器
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // 遇到右括号，开始构造重复的字符串
                StringBuilder decodedString = stringStack.pop(); // 弹出字符串栈顶元素
                int count = countStack.pop(); // 弹出数字栈顶元素
                for (int i = 0; i < count; i++) {
                    decodedString.append(currentString); // 重复构造字符串
                }
                currentString = decodedString; // 更新当前字符串为解码后的字符串
            } else {
                // 是字母，直接添加到当前字符串
                currentString.append(ch);
            }
        }
        return currentString.toString(); // 返回最终构建的字符串
    }


}
