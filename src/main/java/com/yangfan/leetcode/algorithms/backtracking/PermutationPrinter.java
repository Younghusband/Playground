package com.yangfan.leetcode.algorithms.backtracking;

/**
 * 全排列打印字符串
 */
public class PermutationPrinter {
    
    private void permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            // 选择当前字符
            char ch = str.charAt(i);
            // 剩余的字符串
            String ros = str.substring(0, i) + str.substring(i + 1);
            // 递归调用，继续选择下一个字符
            permute(ros, ans + ch);
        }
    }

    public static void main(String[] args) {
        PermutationPrinter printer = new PermutationPrinter();
        String str = "ABC";
        printer.permute(str, "");
    }
}
