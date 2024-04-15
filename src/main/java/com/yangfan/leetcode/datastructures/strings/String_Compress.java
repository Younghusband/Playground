package com.yangfan.leetcode.datastructures.strings;

import java.util.Scanner;

/**
 * 面试题 01.06. 字符串压缩
 */
public class String_Compress {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(compress(input));
    }

    public static String compress(String str) {
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
