package com.yangfan.exam.archive;

import com.yangfan.playground.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找一个数组中出现最多次数的值，如果存在相同的数量按照大的值输出
 */
public class Top1 {
    public static void main(String[] args) {
        int [] arr = ArrayUtil.generateRandomArray(10, 20);
        for(int num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        printTop1(arr);
    }
    static void printTop1(int [] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        int maxNum = arr[0];
        for(int num: arr) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
            // 最大值被更新
            if(count > maxCount) {
                maxCount = count;
                maxNum = num;
            }
            // 出现另一个最大值
            else if(count == maxCount && num > maxNum) {
                maxNum = num;
            }
        }

        System.out.println("出现次数最多的数是: " + maxNum);

    }


}
