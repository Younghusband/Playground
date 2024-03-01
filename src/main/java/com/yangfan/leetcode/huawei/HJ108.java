package com.yangfan.leetcode.huawei;

import java.util.Scanner;

/**
 * 求最小公倍数，需要先求最大公约数
 *
 * b == 0 ? a : gcd(b, a%b)
 */
public class HJ108 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(lcm(a, b));
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }



}
