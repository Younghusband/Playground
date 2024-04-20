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


}
