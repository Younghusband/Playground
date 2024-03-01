package com.yangfan.leetcode.huawei;

import java.util.*;

public class HJ106 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            System.out.println(reverse(sc.nextLine()));
        }
        sc.close();
    }

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}
