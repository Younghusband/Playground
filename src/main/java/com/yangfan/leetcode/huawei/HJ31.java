package com.yangfan.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 *
 * Pattern  Mathcer  find()  group()的使用
 *
 */
public class HJ31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            Matcher helper = Pattern.compile("[a-zA-Z]+").matcher(str);
            List<String> strList = new ArrayList<>();
            while(helper.find()) {
                strList.add(helper.group());
            }

            for(int i = strList.size() - 1; i >= 0; i--) {
                System.out.print(strList.get(i));
                if(i != 0)
                    System.out.print(" ");
            }
            System.out.println();
        }
        sc.close();
    }

}
