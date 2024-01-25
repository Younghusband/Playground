package com.yangfan.leetcode.miscellaneous.bitmanipulation;


import java.util.List;

/**
 * 2859. Sum of Values at Indices With K Set Bits
 *
 * You are given a 0-indexed integer array nums and an integer k.
 * Return an integer that denotes the sum of elements in nums
 * whose corresponding indices have exactly k set bits in their binary representation.
 * The set bits in an integer are the 1's present when it is written in binary.
 *
 * For example, the binary representation of 21 is 10101, which has 3 set bits.
 *
 * 二进制计算，没啥值得注意的。
 * 注意，人家要确认的是下标的置位，而不是元素的置位
 *
 * 掌握Brian Kernighan算法即可
 */
public class Sum_of_Values_at_Indices_With_K_Set_Bits {

    /**
     * 最快的解法是用回溯的，搞不定
     */


    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(bitCount(i) == k)
                ans += nums.get(i);
        }
        return ans;
    }

    int bitCount(int x) {
        int cnt = 0;
        while(x != 0) {
            cnt += (x % 2);
            x >>= 1;
        }
        return cnt;
    }

    /**
     * Brian Kernighan算法
     */
    public int bitCountPro(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1); // 将x的最低位的1变为0
            ones++;  // 计数器加1
        }
        return ones;
    }

    /**
     *
     */
    public int bitCountProMax(int x) {
        x = (x & 0b0101010101) + ((x & 0b1010101010) >> 1);
        x = ((x & 0b0011001100) >> 2) + (x & 0b1100110011);
        x = (x >> 8) + ((x >> 4) & 0b1111) + (x & 0b1111);
        return x;
    }




}
