package com.yangfan.leetcode.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * sc.nextInt() 跨行，跨空格
 */
public class HJ8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int next = sc.nextInt();
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for (int i = 0; i < next; i++) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                if (map.containsKey(key)){
                    map.put(key, map.get(key) + value);
                }else {
                    map.put(key, value);
                }
            }
            for (Map.Entry<Integer, Integer> dataEntry : map.entrySet()) {
                System.out.println(dataEntry.getKey() + " " + dataEntry.getValue());
            }
        }
    }

        public static void my(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> dataMap = new HashMap();
        while(scanner.hasNextLine()) {
            String source = scanner.nextLine();
            String [] data = source.split(" ");
            Integer key = Integer.valueOf(data[0]);
            Integer value = Integer.valueOf(data[1]);

            Integer oldV = dataMap.getOrDefault(key, 0);
            oldV += value;
            dataMap.put(key, oldV);
        }

        for(Map.Entry<Integer, Integer> entry : dataMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey()).append(" ").append(entry.getValue());
            System.out.println(sb);
        }
    }

}
