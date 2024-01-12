package com.yangfan.playground.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport是一个非常方便实用的线程阻塞工具，它可以在线程内任意位置让线程阻塞。
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("child thread begin park!");
            // 调用park方法，挂起自己
            LockSupport.park();
            System.out.println("child thread unpark!");
        });
        t.start();


        // 主线程休眠1s
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread begin unpark!");
        // 调用unpark方法让t线程持有许可证，然后park方法返回
        LockSupport.unpark(t);
    }
}
