package com.yangfan.leetcode.datastructures.strings;

/**
 * 151. Reverse Words in a String
 * 反转字符串中的单词
 *
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 *
 * 核心: 空格处理
 *
 */
public class Reverse_Words_in_a_String {

    public static void main(String[] args) {
        String x = "a good   example";
        String [] words = x.split(" ");
        // 打印数组
        for(String word : words) {
            System.out.print(word + "|");
        }
    }

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // 匹配一个或多个空格 “\s代表空白字符”
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }


}
