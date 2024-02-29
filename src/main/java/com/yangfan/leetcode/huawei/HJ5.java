package com.yangfan.leetcode.huawei;

import java.util.Scanner;

public class HJ5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String hexStr = in.nextLine();
//            int result = Integer.parseInt(hexStr.substring(2), 16);
            int result = Integer.decode(hexStr);
            System.out.println(result);
        }
        in.close();
    }

}
