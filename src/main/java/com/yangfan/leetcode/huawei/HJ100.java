package com.yangfan.leetcode.huawei;

import java.util.Scanner;

public class HJ100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int base = 2, x = 3;
            int sum = base;
            for(int i = 2; i <= n; i++) {
                base += x;
                sum += base;
            }
            System.out.println(sum);
        }
        sc.close();
    }

}
