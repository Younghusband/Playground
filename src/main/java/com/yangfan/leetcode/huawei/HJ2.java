package com.yangfan.leetcode.huawei;

import java.util.Scanner;

public class HJ2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        char target = sc.nextLine().toLowerCase().charAt(0);
        int count = 0;
        for(char x : str.toCharArray()) {
            if(x == target) {
                count++;
            }
        }
        System.out.println(count);
    }


}
