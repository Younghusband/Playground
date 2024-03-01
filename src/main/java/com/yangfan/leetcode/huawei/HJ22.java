package com.yangfan.leetcode.huawei;

import java.util.Scanner;

public class HJ22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            if(n != 0)
                System.out.println(maxDrinks(n));
        }
        sc.close();
    }

    public static int maxDrinks(int n) {
        int count = 0;
        while(n >= 3) {
            int drink = n / 3;
            // 先喝
            count += drink;
            // 后换
            n = n % 3 + drink;
        }
        if(n == 2)
            count++;
        return count;
    }


}
