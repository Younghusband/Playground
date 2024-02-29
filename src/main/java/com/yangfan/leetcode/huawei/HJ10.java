package com.yangfan.leetcode.huawei;

import java.util.*;

public class HJ10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(countDifferentChars(sc.nextLine().trim()));
        }
        sc.close();
    }

    public static int countDifferentChars(String s) {
        boolean[] charExists = new boolean[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charExists[c]) {
                charExists[c] = true;
                count++;
            }
        }
        return count;
    }

}
