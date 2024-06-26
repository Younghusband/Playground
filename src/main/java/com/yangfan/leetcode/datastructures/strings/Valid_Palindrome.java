package com.yangfan.leetcode.datastructures.strings;


/**
 * 125. Valid Palindrome
 * 验证回文串
 *
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 *
 */
public class Valid_Palindrome {

    /**
     * 标准双指针法求解
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            // 快速跳过无效字符
            while(left < right && !Character.isLetterOrDigit(leftC)) {
                left++;
                leftC = s.charAt(left);
            }
            while(left < right && !Character.isLetterOrDigit(rightC)) {
                right--;
                rightC = s.charAt(right);
            }
            // 如果不等于，说明不是回文
            if(Character.toLowerCase(leftC) != Character.toLowerCase(rightC)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 用api的话，就全他妈是细节
     */
    public boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c)); // 细节
            }
        }
        StringBuilder sbRev = new StringBuilder(sb).reverse(); // 细节
        return sb.toString().equals(sbRev.toString()); // 细节
    }


}
