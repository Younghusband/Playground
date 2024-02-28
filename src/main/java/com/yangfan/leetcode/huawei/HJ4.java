package com.yangfan.leetcode.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ4 {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while(in.hasNext()) {
            String line = in.nextLine();
            List<String> completeStr = splitStr(line);
            for(String str: completeStr) {
                System.out.println(str);
            }
        }
        in.close();
    }

    static List<String> splitStr(String str) {
        List<String> res = new ArrayList<>();
        int len = str.length() % 8 == 0 ? str.length() : (str.length() + (8 - str.length() % 8));
        StringBuilder sb = new StringBuilder(str);
        while(sb.length() < len) {
            sb.append("0");
        }
        String newStr = sb.toString();
        for(int i = 0; i < len; i+=8) {
            res.add(newStr.substring(i, i + 8));
        }
        return res;
    }

}
