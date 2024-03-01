package com.yangfan.leetcode.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class HJ58 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] data = new int[n];
        for(int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        Arrays.sort(data);
        for(int i = 0; i < k; i++) {
            System.out.print(data[i] + " ");
        }
    }

}
