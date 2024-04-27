package com.yangfan.leetcode.math;

import java.util.*;
public class Lcm_Gcd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lcmN = 1;
        for(int i = 1; i <= n; i++) {
            lcmN = lcm(lcmN, i);
        }
        System.out.println(lcmN);
    }

    /**
     * 最大公约数
     */
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    /**
     * 最小公倍数
     */
    private static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }


}
