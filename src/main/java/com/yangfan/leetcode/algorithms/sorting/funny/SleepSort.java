package com.yangfan.leetcode.algorithms.sorting.funny;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SleepSort {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        SleepSort sort = new SleepSort();
        for(int num : sort.sleepSort(arr)) {
            System.out.println(num);
        }
    }

    public int[] sleepSort(int[] arr) {
        List<Thread> threadList = new ArrayList<>();
        int[] res = new int[arr.length];
        AtomicInteger j = new AtomicInteger();
        for (int i = 0; i < arr.length; i++) {
            int finalI = i;
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(100 * arr[finalI]);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 正确处理中断异常
                    throw new RuntimeException(e);
                }
                res[j.getAndIncrement()] = arr[finalI];
            });
            threadList.add(t);
            t.start();
        }

        // 等待所有线程完成
        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // 正确处理中断异常
                e.printStackTrace();
            }
        }
        return res;
    }





}
