package com.yangfan.playground.xjb.thread;

/**
 * 守护线程会随着其他所有的非守护线程的结束而结束
 *
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon: I am still alive");
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();

        while(true) {
            Thread.State currentState = daemonThread.getState();
            System.out.println("Daemon current state: " + currentState);
            if(currentState == Thread.State.TIMED_WAITING) {
                break;
            }
        }

        // 主线程休眠2s
        try {
            Thread.sleep(5000);
            System.out.println("Main thread is over.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
