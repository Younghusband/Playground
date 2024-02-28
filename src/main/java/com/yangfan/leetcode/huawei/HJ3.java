package com.yangfan.leetcode.huawei;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer N = in.nextInt();
        Set<Integer> source = new TreeSet<>();
        for(int i = 1; i <= N; i++) {
            source.add(in.nextInt());
        }
        for(Integer item: source) {
            System.out.println(item);
        }
    }


}
