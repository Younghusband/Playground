package com.yangfan.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * 电话号码的字母组合
 *
 * 详见
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description
 *
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 *
 */
public class Letter_Combinations_of_a_Phone_Number {

    public static void main(String[] args) {
        String xxx = "23";
        System.out.println(xxx.charAt(0) - '0');
    }

    // 初始化键盘
    private String[] letterMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    List<String> combo = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return combo;
        }
        bt(0, digits);
        return combo;
    }

    void bt(int index, String digits) {
        if(index == digits.length()) {
            combo.add(sb.toString());
            return;
        }
        String letters = letterMap[digits.charAt(index) - '0'];
        for(char letter : letters.toCharArray()) {
            sb.append(letter);
            bt(index + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
