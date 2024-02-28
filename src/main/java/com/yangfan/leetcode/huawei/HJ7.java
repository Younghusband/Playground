package com.yangfan.leetcode.huawei;

import java.util.Scanner;

public class HJ7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        double num = scanner.nextDouble();
//        long roundedNum = Math.round(num);
//        System.out.println(roundedNum);

        float num = scanner.nextFloat();  // 题目要求32位浮点数
        long roundedNum = Math.round(num);
        System.out.println(roundedNum);
        scanner.close();

    }

}
