package com.yangfan.leetcode.trick.bitmanipulation;

/**
 * 231. Power of Two
 * 2的幂
 *
 */
public class Power_of_Two {

    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        return (n & (n - 1)) == 0;
    }

}
