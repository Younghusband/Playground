package com.yangfan.leetcode.datastructures.strings;

/**
 * 443. String Compression
 * 字符串压缩
 *
 * 傻逼题目
 *
 * 注意要做两件事
 * 1. 计算出压缩后的数组长度
 * 2. 与此同时，原地修改数组为压缩后的数组
 *
 * 但是他妈的只返回长度
 */
public class String_Compression {

    /**
     * 指针left标记重复字符串的左侧
     * 指针read标记读取进度
     * 指针write负责落后写入结果
     */
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            // 当读到最后一个字符或当前字符与下一个字符不同，处理当前字符序列
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;    // 计算当前字符连续出现的次数
                if (num > 1) {
                    // 这个地方比较巧妙，比他妈 /= 10 计数要聪明太多
                    for (char c : Integer.toString(num).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                left = read + 1; // 更新left为下一个新字符的起始位置
            }
        }
        return write;
    }

    /**
     * 面试题 01.06. 字符串压缩
     * 简单一些
     *
     * 示例1:
     *  输入："aabcccccaaa"
     *  输出："a2b1c5a3"
     * 示例2:
     *  输入："abbccd"
     *  输出："abbccd"
     *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     *
     */
    public String compress(String str) {
        if (str == null || str.isEmpty()) return str;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prevChar = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == prevChar) {
                count++;  // 增加当前字符的计数
            } else {
                sb.append(prevChar);  // 追加前一个字符
                sb.append(count);  // 只有当计数大于1时才追加计数
                prevChar = currentChar;  // 更新当前字符为前一个字符
                count = 1;  // 重置计数
            }
        }
        // 处理最后一组字符和计数
        sb.append(prevChar);
        sb.append(count);
        String compressedStr = sb.toString();
        return compressedStr.length() >= str.length() ? str : compressedStr;
    }


}
