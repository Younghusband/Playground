package com.yangfan.exam;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 输入一个n (1 <= n <= 10000)
 * 求1到n的最小公倍数
 */
public class Zuixiaogongbeishu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        BigInteger res = new BigInteger(nums[0] + "");
        for(int i = 1; i < n; i++) {
            BigInteger t = new BigInteger(nums[i] + "");
            res = res.multiply(t).divide(res.gcd(t));
        }
        System.out.println(res);
    }



}
