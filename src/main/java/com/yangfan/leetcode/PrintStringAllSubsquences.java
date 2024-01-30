package com.yangfan.leetcode;

/**
 * 打印字符串的所有子集
 */
public class PrintStringAllSubsquences {

    public static void main(String[] args) {
        printAllSub("ABC");
    }

    public static void printAllSub(String str) {
        char[] chs = str.toCharArray();
        boolean[] isIncluded = new boolean[chs.length];
        process(chs, 0, isIncluded);
    }

    public static void process(char[] chs, int i, boolean[] isIncluded) {
        if (i == chs.length) {
            printArray(chs, isIncluded);
            return;
        }
        // 不包含当前字符
        isIncluded[i] = false;
        process(chs, i + 1, isIncluded);

        // 包含当前字符
        isIncluded[i] = true;
        process(chs, i + 1, isIncluded);
    }

    private static void printArray(char[] chs, boolean[] isIncluded) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if (isIncluded[i]) {
                sb.append(chs[i]);
            }
        }
        System.out.println(sb.toString());
    }


}
