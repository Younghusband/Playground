package com.yangfan.leetcode.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 解题思路：
 *
 * 遍历单词列表，对每个单词进行检查，判断是否是兄弟单词。
 * 如果是兄弟单词，将其添加到兄弟单词列表中。
 * 对兄弟单词列表进行字典序排序。
 * 输出兄弟单词列表的长度，以及第 k 个兄弟单词（如果存在）。
 *
 * 输入描述：
 * 输入只有一行。 先输入字典中单词的个数n，再输入n个单词作为字典单词。 然后输入一个单词x 最后后输入一个整数k
 * 输出描述：
 * 第一行输出查找到x的兄弟单词的个数m 第二行输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 */
public class HJ27 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            String [] data = new String[n];
            for(int i = 0; i < n; i++) {
                data[i] = sc.next();
            }
            String bro = sc.next();
            int k = sc.nextInt();
            List<String> broList = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(isBro(bro, data[i])) {
                    broList.add(data[i]);
                }
            }
            Collections.sort(broList);
            System.out.println(broList.size());
            if(k <= broList.size()) {
                System.out.println(broList.get(k - 1));
            }
        }
        sc.close();
    }

    static boolean isBro(String src, String target) {
        if(src.equals(target) || src.length() != target.length()) return false;
        byte [] letters = new byte[26]; // 用于统计字母出现次数
        for (char c : src.toCharArray()) {
            letters[c - 'a']++; // 统计word中的字母
        }
        for (char c : target.toCharArray()) {
            letters[c - 'a']--; // 减去target中的字母
        }
        for (int count : letters) {
            if (count != 0)
                return false; // 如果有字母计数不为0，则不是兄弟单词
        }
        return true; // 所有字母计数为0，是兄弟单词
    }


}
