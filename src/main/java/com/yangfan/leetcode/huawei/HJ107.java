package com.yangfan.leetcode.huawei;

public class HJ107 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double data = Double.parseDouble(sc.nextLine());
//        System.out.println(cubeRoot(data));

        double x = 31;
        System.out.println(x/10);
        System.out.println(x/10.0);

    }

    public static double cubeRoot(double x) {
        double epsilon = 1e-6; // 精度 6~8之间，越精确越慢
        double guess = x; // 初始猜测值
        while (Math.abs(guess * guess * guess - x) >= epsilon) {
            guess = guess - (guess * guess * guess - x) / (3 * guess * guess);
        }
        return Math.round(guess * 10) / 10.0; // 保留一位小数
    }

}
