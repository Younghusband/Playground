package com.yangfan.exam.archive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class yingbi_duihuan {

    /**
     * 在一个国家仅有1分，2分，3分硬币，将钱N兑换成硬币有很多种兑法，求一共有多少种兑法
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] coins = Stream.of(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int N = sc.nextInt();
        int cnt = calculate(coins, N);
        System.out.println(cnt);

        // 打印ans
        yingbi_duihuan y = new yingbi_duihuan();
        y.permutation(0, coins, N);
        System.out.println(y.ans);
    }

    /**
     * 计算组合数
     */
    static int calculate(int [] coins, int N) {
        int [] dp = new int[N + 1];
        dp[0] = 1;
        for(int coin: coins) {
            for(int i = coin; i <= N; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[N];
    }

    /**
     * 列出所有组合
     */
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    void permutation(int start, int [] coins, int remain) {
        if(remain == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if(remain > 0) {
            for(int i = start; i < coins.length; i++) {
                path.add(coins[i]);
                permutation(i, coins, remain - coins[i]);
                path.remove(path.size() - 1);
            }
        }
    }









}
