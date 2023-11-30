package com.yangfan.playground.algorithm;

import com.yangfan.playground.util.ArrayUtil;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    void test1() {
        int N = 8;
        int [] memo = new int[N+1];
        int result = fibWithMemo(memo, N);
//        int result = fib(N);
        System.out.println("第"+N+"项的fib值为"+result);
        ArrayUtil.printArray(memo);
    }

    int fibWithMemo(int [] memo, int N) {
        if(N == 0 || N == 1) {
            memo[N] = N;
            return N;
        }
        if(memo[N] != 0)
            return memo[N];
        memo[N] = fibWithMemo(memo, N-1) + fibWithMemo(memo, N-2);
        return memo[N];
    }

    int fib(int N) {
        if(N == 0 || N == 1) {
            return N;
        }
        int result = fib(N-2) + fib(N-1);
        System.out.println(result + "当前N为" + N);
        return result;
    }

}
