package com.yangfan.playground;

import com.yangfan.playground.util.ArrayUtil;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    
    public static void main(String[] args) {

        // 声明一个数组，用于冒泡排序
        int [] arr = ArrayUtil.createRandomArray(10,50, 0.01);
        // 打印数组arr
        System.out.println("排序前：");
        ArrayUtil.printArray(arr);
        // 排序
        System.out.println("排序后：");
        ArrayUtil.printArray(arr);

    }







}
