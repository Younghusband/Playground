package com.yangfan.playground.util;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ArrayUtil {


    /**
     * 重写该方法，默认重复因子为0
     */
    public static int [] createRandomArray(int length, int max) {
        return createRandomArray(length, max, 0);
    }

    /**
     * 创建一个随机的自然数数组
     * 入参为数组长度和数组最大值，以及重复因子范围[0,1]
     * 重复因子为0时，数组中绝对不会有重复元素, 1则是完全不管是否有重复的元素，在中间的话值越大，重复的元素越多
     */
    public static int [] createRandomArray(int length, int max, double repeatFactor) {
        int[] arr = new int[length];
        Random random = new Random();
        Set<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(max);
            if (set.contains(num)) {
                if (random.nextDouble() < repeatFactor) {
                    arr[i] = num;
                } else {
                    i--;
                }
            } else {
                arr[i] = num;
                set.add(num);
            }
        }
        return arr;
    }


    // 打印数组 格式为 [a,b,c,d]. 输入为数组
    public static void printArray(int [] arr) {
        System.out.print("[");
        for(int i=0; i<arr.length; i++) {
            if(i == arr.length-1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.println("]");
    }

    /**
     * 交换数组中两个元素的位置，入参为数组和两个元素的下标，效率要高
     */
    public static void swap(int [] arr, int i, int j) {
        if (i == j) {
            return;
        }
        //由于j和j+1不相等，这是两个元素 所以放心大胆使用异或交换
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[j] ^ arr[i];
    }


}
