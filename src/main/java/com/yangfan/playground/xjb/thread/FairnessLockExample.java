package com.yangfan.playground.xjb.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示公平锁和非公平锁
 *
 * 效果就是公平锁会按照线程启动的顺序来获取锁，而非公平锁则不会。
 */
public class FairnessLockExample {
    private static final Lock fairLock = new ReentrantLock(true); // 公平锁
    private static final Lock unfairLock = new ReentrantLock();    // 非公平锁

    public static void main(String[] args) {
        // 公平锁示例
        Runnable fairTask = () -> {
            for (int i = 0; i < 5; i++) {
                fairLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " 获取了公平锁");
                } finally {
                    fairLock.unlock();
                }
            }
        };

        // 非公平锁示例
        Runnable unfairTask = () -> {
            for (int i = 0; i < 5; i++) {
                unfairLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " 获取了非公平锁");
                } finally {
                    unfairLock.unlock();
                }
            }
        };

        // 启动多个线程演示公平锁和非公平锁
        for (int i = 0; i < 3; i++) {
            new Thread(fairTask, "FairThread-" + i).start();
            new Thread(unfairTask, "UnfairThread-" + i).start();
        }
    }

}
