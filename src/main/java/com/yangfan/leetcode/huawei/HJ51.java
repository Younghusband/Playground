package com.yangfan.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ51 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int len = sc.nextInt();
            List<Integer> data = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                data.add(sc.nextInt());
            }
            int k = sc.nextInt();
            System.out.println(data.get(len - k));
        }
        sc.close();
    }


}
