package com.yangfan.exam.archive;

import java.util.Scanner;

/**
 * 输入一个n (1 <= n <= 10000)
 * 求1到n的最小公倍数
 */
public class Zuixiaogongbeishu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lcmN = 1;
        for(int i = 1; i <= n; i++) {
            lcmN = lcm(lcmN, i);
        }
        System.out.println(lcmN);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }



}
