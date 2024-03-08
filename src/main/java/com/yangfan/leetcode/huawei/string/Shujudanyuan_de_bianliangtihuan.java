package com.yangfan.leetcode.huawei.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 数据单元的变量替换 100
 *
 */
public class Shujudanyuan_de_bianliangtihuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sourceData = sc.nextLine();

        String [] data = sourceData.split(",");
        if(!process(data)) {
            System.out.println(-1);
        } else {
            for(int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
                if(i != data.length - 1)
                    System.out.print(",");
            }
            System.out.println();
        }
    }

    static boolean process(String [] strArr) {
        boolean hasLeft = false;
        // 第一遍收集map 并尝试替换
        Map<String, String> relateMap = new HashMap<>();
        for(int i = 0; i < strArr.length; i++) {
            String cur = strArr[i];
            String perhapsKey = String.valueOf((char)('A' + i));
            int left = cur.indexOf("<");
            int right = cur.indexOf(">");

            // 无括号，可能被引用
            if(left == -1 && right == -1) {
                relateMap.put(perhapsKey, cur);
            }
            // < 和 > 都有 且正常包裹
            else if(left != -1 && right != -1 && right == left + 2) {
                // 获取引用的值
                String relatedKey = cur.substring(left + 1, right);
                // 尝试替换
                if(relateMap.containsKey(relatedKey)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(cur.substring(0, left + 1)); // xxx<
                    sb.append(relateMap.get(relatedKey)); // 替换值
                    sb.append(cur.substring(right)); // >xxx

                    cur = sb.toString();
                    cur = cur.replace("<","").replace(">","");
                    strArr[i] = cur;
                } else {
                    hasLeft = true;
                }
            }
            // 不正常字符串
            else {
                return false;
            }
        }

        // 第二遍遍历，补充未填充的值
        if(hasLeft) {
            for(int i = 0; i < strArr.length; i++) {
                String cur = strArr[i];
                int left = cur.indexOf("<");
                int right = cur.indexOf(">");
                if(left == -1 && right == -1) {
                }
                // 填充
                else {
                    // 获取引用的值
                    String relatedKey = cur.substring(left + 1, right);
                    if(relateMap.containsKey(relatedKey)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(cur.substring(0, left + 1)); // xxx<
                        sb.append(relateMap.get(relatedKey)); // 替换值
                        sb.append(cur.substring(right)); // >xxx

                        cur = sb.toString();
                        cur = cur.replace("<","").replace(">","");
                        strArr[i] = cur;
                    } else {
                        // 异常情况了
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
