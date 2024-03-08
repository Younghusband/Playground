package com.yangfan.leetcode.datastructures.hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 *
 * 快乐数
 *
 * 这道题的核心在于识别循环，以及将其和链表联系在一起的能力。
 *
 */
public class Happy_Number {

    /**
     * 标准解法
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = next(n); // 为了进while

        while(slow != fast) {
            slow = next(slow);
            fast = next(next(fast));
        }
        if(slow == 1 || fast == 1)
            return true;
        return false;
    }

    /**
     * 相当于暴力遍历链表
     */
    public boolean brute(int n) {
        Set<Integer> helper = new HashSet<>();
        while(n != 1) {
            // 出现循环
            if(!helper.add(n))
                return false;
            n = next(n);
        }
        return true;
    }

    /**
     * 您会发现只有一个循环
     * 要么进入这个循环，要么在变成1的路上
     */
    private static Set<Integer> cycleMembers =
            new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));
    public boolean byMath(int n) {
        while(n != 1) {
            if(cycleMembers.contains(n)) // 这里就不能添加新值了
                return false;
            n = next(n);
        }
        return true;
    }

    /**
     * next 这个方法名妙，懂的都懂
     */
    int next(int num) {
        int sum = 0;
        while(num > 0) {
            int d = num % 10;
            sum += d * d;
            num /= 10;
        }
        return sum;
    }

}
