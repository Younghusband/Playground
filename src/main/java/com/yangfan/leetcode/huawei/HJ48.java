package com.yangfan.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一行，有以下4个部分：
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 */
public class HJ48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int count = sc.nextInt();
            int head = sc.nextInt();

            List<Integer> link = new ArrayList<>();
            link.add(head);
            for(int i = 0; i < count - 1; i++) {
                int value = sc.nextInt();
                int target = sc.nextInt();

                // 把成对出现的数的第一个数放到第二个数的下一个位置
                link.add(link.indexOf(target) + 1, value);
            }
            int k = sc.nextInt();
            link.remove(link.indexOf(k));
            for(int i = 0; i < link.size(); i++) {
                System.out.print(link.get(i));
                if(i != link.size() - 1)
                    System.out.print(" ");
            }
        }
        sc.close();
    }

}
