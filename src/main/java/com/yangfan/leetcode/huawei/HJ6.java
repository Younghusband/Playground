package com.yangfan.leetcode.huawei;

import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 */
public class HJ6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= Math.sqrt(x); i++) {
            while(x % i == 0) {
                sb.append(i + " ");
                x /= i;
            }
        }
        if(x > 1) sb.append(x);
        System.out.println(sb.toString().trim());
    }
}
