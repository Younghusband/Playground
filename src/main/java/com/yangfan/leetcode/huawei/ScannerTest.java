package com.yangfan.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> data = new ArrayList<>();
        while(sc.hasNext()) {
            for(int i = 0; i < 5; i++)
                data.add(sc.nextInt());
            System.out.println("下一轮回");
        }
        System.out.println(data);
    }


}
