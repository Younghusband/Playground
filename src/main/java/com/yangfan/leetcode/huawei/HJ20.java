package com.yangfan.leetcode.huawei;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *  密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 *
 * 难点:
 * 1. 正则判断
 * 2. 重复子串判断
 */
public class HJ20 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            if (str.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            if (!getMatch(str)) {
                System.out.println("NG");
                continue;
            }
            if (getString(str, 0, 3)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
        sc.close();
    }
    // 校验是否有重复子串
    private static boolean getString(String str, int l, int step) {
        if (l + step > str.length()) {
            return false;
        }
        String cur = str.substring(l, l + step);
        if (str.substring(l + step).contains(cur))
            return true;
        return getString(str, l + 1, step);
    }

    // 检查是否包括大小写字母.数字.其它符号,以上四种至少三种
    private static boolean getMatch(String str) {
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if (p1.matcher(str).find()) {
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if (p2.matcher(str).find()) {
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if (p3.matcher(str).find()) {
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]"); // 这个正则内容容易遗漏
        if (p4.matcher(str).find()) {
            count++;
        }
        return count >= 3;
    }
}
