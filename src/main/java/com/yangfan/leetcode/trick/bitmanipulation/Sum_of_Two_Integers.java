package com.yangfan.leetcode.trick.bitmanipulation;

/**
 * 371. Sum of Two Integers
 * 两整数之和
 *
 * Given two integers a and b,
 * return the sum of the two integers without using the operators + and -.
 *
 */
public class Sum_of_Two_Integers {

    public int getSum(int a, int b) {
        while(b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }


}
