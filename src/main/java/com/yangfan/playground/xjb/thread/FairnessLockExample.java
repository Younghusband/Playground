package com.yangfan.playground.xjb.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示公平锁和非公平锁
 *
 * 1. 公平锁：按照线程请求的顺序来分配锁，即先到先得的FIFO先进先出顺序。
 * 2. 非公平锁：一种获取锁的抢占机制，
 *  是随机获得锁的，和公平锁不一样的是，非公平锁不管是不是已经有线程在等待，都会直接尝试获取锁
 *  很有可能的表现为一直是一个线程占有锁，其他线程一直在等待。
 */
public class FairnessLockExample {
    private static final Lock fairLock = new ReentrantLock(true); // 公平锁
    private static final Lock unfairLock = new ReentrantLock();    // 非公平锁

    public static void main(String[] args) {
//        testFairLock();
        testUnfairLock();
    }

    public static void testFairLock() {
        Runnable runnable = () -> {
            while (true) {
                try {
                    fairLock.lock();
                    System.out.println(Thread.currentThread().getName() + " 获得了公平锁。");
//                    System.out.println("当前等待线程数：" + ((ReentrantLock) fairLock).getQueueLength());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    fairLock.unlock();
                }
            }
        };

        // 创建多个线程并启动
        Thread thread1 = new Thread(runnable, "FairThread-1");
        Thread thread2 = new Thread(runnable, "FairThread-2");
        Thread thread3 = new Thread(runnable, "FairThread-3");

        thread1.start();
        thread2.start();
        thread3.start();

    }

    public static void testUnfairLock() {
        Runnable runnable = () -> {
            while (true) {
                try {
                    unfairLock.lock();
                    System.out.println(Thread.currentThread().getName() + " 获得了非公平锁。");
//                    System.out.println("当前等待线程数：" + ((ReentrantLock) unfairLock).getQueueLength());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    unfairLock.unlock();
                }
            }
        };

        // 创建多个线程并启动
        Thread thread1 = new Thread(runnable, "UnFairThread-1");
        Thread thread2 = new Thread(runnable, "UnFairThread-2");
        Thread thread3 = new Thread(runnable, "UnFairThread-3");

        thread1.start();
        thread2.start();
        thread3.start();

    }

}
