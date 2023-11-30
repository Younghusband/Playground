package com.yangfan.playground.problems.code.easy;

import com.yangfan.playground.util.ArrayUtil;

/**
 * No.509
 * 1. 递归+备忘录
 * 2. 迭代
 */
public class Fibonacci_Number {

    /**
     * 标准迭代
     */
    int fibStandard(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int sum = 0;
        int p1 = 0, p2 = 1;
        for(int i = 2; i < n+1; i++) {
            sum = p1 + p2;
            p1 = p2;
            p2 = sum;
        }
        return sum;
    }


    /**
     * O(n)
     * 加上备忘录剪枝
     */
    int fibWithMemo(int [] memo, int n) {
        if(n == 0 || n == 1) {
            memo[n] = n;
            return n;
        }
        if(memo[n] != 0)
            return memo[n];
        memo[n] = fibWithMemo(memo, n-1) + fibWithMemo(memo, n-2);
        return memo[n];
    }

    /**
     * O(2^n)
     * 会有非常多重叠子问题
     */
    int fib(int n) {
        return n <= 1 ? n : fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Fibonacci_Number f = new Fibonacci_Number();
        int N = 8;
        int [] memo = new int[N+1];
        int result = f.fibStandard(N);
//        int result = f.fibWithMemo(memo, N);
//        int result = fib(N);
        System.out.println("第"+N+"项的fib值为"+result);
//        ArrayUtil.printArray(memo);
    }



}
