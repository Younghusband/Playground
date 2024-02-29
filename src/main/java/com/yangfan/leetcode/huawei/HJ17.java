package com.yangfan.leetcode.huawei;

import java.util.*;

public class HJ17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(calculateFinalPosition(sc.next()));
        }
        sc.close();
    }

    public static String calculateFinalPosition(String input) {
        String[] moves = input.split(";");
        int x = 0, y = 0;
        for (String move : moves) {
            if (move.matches("[ADWS]\\d{1,2}")) { // [ADWS][0-9]{1,2} 也行
                char direction = move.charAt(0);
                int distance = Integer.parseInt(move.substring(1));
                switch (direction) { // 用字符串也行
                    case 'A':
                        x -= distance;
                        break;
                    case 'D':
                        x += distance;
                        break;
                    case 'W':
                        y += distance;
                        break;
                    case 'S':
                        y -= distance;
                        break;
                }
            }
        }
        return x + "," + y;
    }
}
