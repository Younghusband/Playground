package com.yangfan.leetcode.huawei;

import java.util.Scanner;

public class HJ33 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String input = sc.nextLine();
            if (input.contains(".")) {
                // 输入是IP地址，转换为长整数
                long ipAsLong = ipToLong(input);
                System.out.println(ipAsLong);
            } else {
                // 输入是长整数，转换为IP地址
                String ip = longToIp(Long.parseLong(input));
                System.out.println(ip);
            }
        }
        sc.close();
    }

    public static long ipToLong(String ip) {
        String[] segments = ip.split("\\."); // 按"."分割IP地址
        long result = 0; // 初始化结果为0
        for (int i = 0; i < segments.length; i++) {
            int segment = Integer.parseInt(segments[i]); // 将每段转换为整数
            result |= (segment & 0xFF) << ((3 - i) * 8); // 将每段左移相应的位数并累加到结果中
        }
        return result & 0xFFFFFFFFL; // 确保结果是无符号的32位整数
    }

    public static String longToIp(long ipAsLong) {
        StringBuilder sb = new StringBuilder(); // 使用StringBuilder构建IP地址字符串
        for (int i = 3; i >= 0; i--) {
            sb.append((ipAsLong >> (i * 8)) & 0xFF); // 从长整数中提取每段的值并添加到StringBuilder中
            if (i > 0) {
                sb.append("."); // 在每段之间添加"."
            }
        }
        return sb.toString(); // 返回构建好的IP地址字符串
    }

}
