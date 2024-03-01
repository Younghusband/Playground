package com.yangfan.leetcode.huawei;

import java.util.Scanner;

public class HJ23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            System.out.println(process(sc.nextLine()));
        }
        sc.close();
    }

    static String process(String str) {
        StringBuilder sb = new StringBuilder();
        if(str.length() == 1) return str;
        char [] charArr = str.toCharArray();
        byte [] count = new byte[26];
        for(int i = 0; i < charArr.length; i++) {
            count[charArr[i] - 'a']++;
        }
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) minCount = Math.min(count[i], minCount);
        }
        for(int i = 0; i < charArr.length; i++) {
            if(count[charArr[i] - 'a'] == minCount)
                continue;
            sb.append(charArr[i]);
        }
        return sb.toString();
    }



}
