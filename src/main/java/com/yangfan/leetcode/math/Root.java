package com.yangfan.leetcode.math;

public class Root {

    /**
     * 平方根
     */
    public static double sqrt(double x) {
        if (x < 0) {
            return Double.NaN; // 对于负数，返回NaN
        }
        double epsilon = 1e-6; // 精度
        double guess = x; // 初始猜测值
        while (Math.abs(guess * guess - x) >= epsilon) {
            guess = (guess + x / guess) / 2; // 牛顿迭代公式
        }
        return Math.round(guess * 10) / 10.0; // 保留一位小数
    }

    /**
     * 立方根
     */
    public double cubeRoot(double x) {
        double epsilon = 1e-6; // 精度 6~8之间，越精确越慢
        double guess = x; // 初始猜测值
        while (Math.abs(guess * guess * guess - x) >= epsilon) {
            guess = guess - (guess * guess * guess - x) / (3 * guess * guess);
        }
        return Math.round(guess * 10) / 10.0; // 保留一位小数
    }


}
