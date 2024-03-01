package com.yangfan.leetcode.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 学到了Collections.sort的逆序排序
 */
public class HJ101 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> data = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            data.add(sc.nextInt());
        }
        int order = sc.nextInt();
        if(order == 0) {
            Collections.sort(data);
        } else if(order == 1) {
            Collections.sort(data, Collections.reverseOrder());
//            Collections.sort(data, (o1, o2) -> o2.compareTo(o1));
        }
        for(int num: data) {
            System.out.print(num + " ");
        }
    }
}
