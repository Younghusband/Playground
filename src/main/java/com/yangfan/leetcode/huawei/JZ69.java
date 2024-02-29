package com.yangfan.leetcode.huawei;

public class JZ69 {

    public int jumpFloor (int n) {
        int [] memo = new int[n + 1];
        memo[0] = 0;
        return dfs(memo, n);
    }

    public int dfs(int [] memo, int n) {
        if(n == 1 || n == 2) return n;
        if(memo[n] != 0)
            return memo[n];
        int res = dfs(memo,n - 2) + dfs(memo,n - 1);
        memo[n] = res;
        return memo[n];
    }


}
