package com.yangfan.playground.thread.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用大名鼎鼎的睡眠排序来演示CountDownLatch的使用
 *
 * latch的两个方法，countDown() 和 await()
 * await() 会阻塞当前线程，直到latch的count减为0
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        int [] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        CountDownLatchTest test = new CountDownLatchTest();
        for(int num: test.sleepSort(arr)) {
            System.out.println(num);
        }
    }

    int [] sleepSort(int [] nums) throws InterruptedException {
        int len = nums.length;
        int [] res = new int [len];
        CountDownLatch latch = new CountDownLatch(len);
        List<Thread> threadList = new ArrayList<>();
        AtomicInteger index = new AtomicInteger(0);
        for(int i = 0; i < len; i++) {
            final int finalI = i;
            Thread t = new Thread(
                () -> {
                    try {
                        Thread.sleep(100 * nums[finalI]);
                        res[index.getAndIncrement()] = nums[finalI];
                        latch.countDown();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            );
            threadList.add(t);
        }

        for(Thread t: threadList) {
            t.start();
        }
        // latch.await() 会阻塞当前线程，直到latch的count减为0
        latch.await();
        return res;
    }



}
