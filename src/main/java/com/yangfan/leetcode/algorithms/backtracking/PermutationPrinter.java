package com.yangfan.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列打印字符串
 */
public class PermutationPrinter {

    /**
     * 不兼容重复情况
     */
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
//        printer.permute(str, "");
        printer.permute(str.toCharArray());

    }


    List<String> ans = new ArrayList<>();
    List<Character> path = new ArrayList<>();
    public void permute(char [] chars) {
        boolean [] used = new boolean[chars.length];
        bt(used, chars);
        for(String str: ans) {
            System.out.println(str);
        }
    }


    void bt(boolean [] used, char [] chars) {
        if(path.size() == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (Character c : path) {
                sb.append(c); // 添加每个字符到StringBuilder
            }
            ans.add(sb.toString()); // 将构建的字符串添加到结果列表
            return;
        }
        for(int i = 0; i < chars.length; i++) {
            if(used[i]) {
                continue;
            }
            path.add(chars[i]);
            used[i] = true;
            bt(used, chars);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
