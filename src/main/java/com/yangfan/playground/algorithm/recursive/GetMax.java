package com.yangfan.playground.algorithm.recursive;

import com.yangfan.playground.util.ArrayUtil;
import org.springframework.util.StopWatch;

/**
 * 获得数组中的最大值(用递归的方式)
 * 但是，没循环快，主要是学习一下思维
 */


public class GetMax {

    public static void main(String[] args) {
        int [] arr = ArrayUtil.generateRandomArray(1000_0000, 2000_0000);
        StopWatch stopWatch = new StopWatch("取最大值计数器");
        stopWatch.start("task1");
        int maxByRecursive = getMax(arr);
        stopWatch.stop();
        stopWatch.start("task2");
        int maxByLoop = getMaxComparator(arr);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println("递归取最大值，最大值为[" + maxByRecursive + "]。");
        System.out.println("循环取最大值，最大值为[" + maxByLoop + "]。");
    }


    public static int getMax(int [] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int [] arr, int left, int right) {
        if(right == left) {
            return arr[left];
        }
        int mid = (left + right) >>> 1;
        int leftMax = process(arr, left, mid);
        int rightMax = process(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }

    /**
     * 循环的方式，对数
     */
    public static int getMaxComparator(int [] arr) {
        int max = Integer.MIN_VALUE;
        for(int item : arr) {
            if(max < item)
                max = item;
        }
        return max;
    }

}
