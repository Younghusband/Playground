package com.yangfan.leetcode.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            List<String> words = new ArrayList(n);
            for(int i = 0; i < n; i++) {
                words.add(sc.next()); // 想读取一整行再用nextLine()
            }
            Collections.sort(words);
            for(int i = 0; i < n; i++) {
                System.out.println(words.get(i));
            }

        }

    }

}
