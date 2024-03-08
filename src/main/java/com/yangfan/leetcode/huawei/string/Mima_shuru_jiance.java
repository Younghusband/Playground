package com.yangfan.leetcode.huawei.string;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 密码输入检测 100
 */
public class Mima_shuru_jiance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String data = sc.nextLine();
            String processed = processed(data);
            System.out.println(processed + "," + valid(processed));
        }
        sc.close();
    }


    static String processed(String str) {
        int index = str.indexOf("<");
        if(index == -1)
            return str;

        StringBuilder sb = new StringBuilder();
        // left
        if(index > 0) {
            sb.append(str.substring(0, index - 1));
        }
        sb.append(str.substring(index + 1));
        // 递归处理
        return processed(sb.toString());
    }


    static boolean valid(String str) {
        if(str == null || str.length() < 8) {
            return false;
        }
        Pattern p1 = Pattern.compile("[A-Z]");
        if(!p1.matcher(str).find()) {
            return false;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if(!p2.matcher(str).find()) {
            return false;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if(!p3.matcher(str).find()) {
            return false;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if(!p4.matcher(str).find()) {
            return false;
        }

        Pattern p5 = Pattern.compile("\\s");
        // 兜个底
        if(p5.matcher(str).find()) {
            return false;
        }
        return true;
    }


}
