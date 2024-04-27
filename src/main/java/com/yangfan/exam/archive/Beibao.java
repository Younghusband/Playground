package com.yangfan.exam.archive;


import java.util.Scanner;

/**
 * 昨天是三八妇女节，在尧山食堂中央举办了一个活动所有的女童鞋可以再此免费拿走自己想要的物品。
 * 由于时间紧迫，Mary决定要将自己的背包装满。
 * 由于物品较多，且每个物品都有自己的重量，而Mary的背包只能承受固定的重量，
 * 她很烦恼如何才能装满自己的包包，所以现在交给你来将Mary的背包装满吧。
 *
 * 注意：每种物品只能选一次，不考虑包的空间大小。
 *
 * 解答要求
 * 时间限制：1000ms, 内存限制：100MB
 * 输入
 * 输入第一行包含两个空格分开的整数N(1≤ N ≤ 100)和S(1≤ S ≤ 1000)，
 * 现场有N个物品和Mary的背包最多只能装S千克的物品；
 * 第二行是N个正整数Wi(0 < Wi ≤ 100)，表示每个物品的重量(单位千克)。
 *
 * 输出
 * 若能将Mary的背包装满则输出“YES”，否则输出“NO”。
 *
 */
public class Beibao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
        }
        if (canFillBag(weights, S)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }

    public static boolean canFillBag(int[] weights, int maxWeight) {
        boolean[] dp = new boolean[maxWeight + 1];
        dp[0] = true; // 初始化dp[0]为true，表示零容量可以不装任何物品即为"装满"
        // weight在外层，说明了其有限
        for (int weight : weights) {
            for (int j = maxWeight; j >= weight; j--) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        return dp[maxWeight]; // 如果dp[maxWeight]为true，表示可以装满
    }


}
