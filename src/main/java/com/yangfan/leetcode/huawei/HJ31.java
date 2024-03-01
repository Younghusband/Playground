package com.yangfan.leetcode.huawei;

import java.util.Scanner;


/**
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 *
 */
public class HJ31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String src = sc.nextLine().trim();
            String [] words = src.split("\\s+");
            for(int i = words.length - 1; i >= 0; i--) {
                System.out.print(words[i]);
                if(i != 0)
                    System.out.print(" ");
            }
        }
        sc.close();
    }

}
