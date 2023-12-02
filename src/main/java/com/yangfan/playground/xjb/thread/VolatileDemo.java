package com.yangfan.playground.xjb.thread;

/**
 * 不加volatile的情况下，线程B可能会一直循环下去，因为它看不到主线程修改的flag的值
 */
public class VolatileDemo {
    private static volatile boolean flag = false;  // 使用volatile修饰共享变量
//    private static boolean flag = false; // 不使用volatile修饰共享变量

    public static void main(String[] args) {
        // 线程A修改flag的值
        Thread threadA = new Thread(() -> {
            System.out.println("Thread A starts running.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("Thread A sets flag to true.");
        });

        // 线程B读取flag的值
        Thread threadB = new Thread(() -> {
            System.out.println("Thread B starts running.");
            while (!flag) {
                // 等待flag变为true
            }
            System.out.println("Thread B detects flag is true.");
        });

        threadA.start();
        threadB.start();
    }

}
