package com.yangfan.leetcode.huawei;

import java.util.Scanner;

public class HJ15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            System.out.println(oneCount(in.nextInt()));
        }
        in.close();
    }

    static int oneCount(int x) {
        int count = 0;
        while(x != 0) {
            x &= x - 1;
            count++;
        }
        return count;
    }

}
