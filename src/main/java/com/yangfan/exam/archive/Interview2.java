package com.yangfan.exam.archive;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public class Interview2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String one = sc.nextLine();
        String [] xxx = one.split("\\s+");
        int N = Integer.parseInt(xxx[0]);
        int S = Integer.parseInt(xxx[1]);
        int [] wi = new int[N];
        for(int i = 0; i < N; i++) {
            wi[i] = sc.nextInt();
        }
        if(check(wi, S)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    static List<List<Integer>> ans = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    /**
     * 输入第一行包含两个空格分开的整数N(1≤ N ≤ 100)和S(1≤ S ≤ 1000)，
     * 现场有N个物品和Mary的背包最多只能装S千克的物品；
     */
    static boolean check(int [] goods, int max) {
        bt(0, goods);
        Collections.sort(ans, (o1, o2) ->  o2.size() - o1.size());
        for(List<Integer> list : ans) {
            int sum = 0;
            for (int num : list) {
                sum += num;
            }
            if(sum == max) {
                return true;
            }
        }
        return false;
    }

    static void bt(int start, int [] nums) {
        ans.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            bt(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }


}
