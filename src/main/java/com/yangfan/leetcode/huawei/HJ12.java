package com.yangfan.leetcode.huawei;

import java.util.Scanner;

public class HJ12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            StringBuilder sb = new StringBuilder(sc.nextLine());
            System.out.println(sb.reverse());
        }
        sc.close();
    }
}
