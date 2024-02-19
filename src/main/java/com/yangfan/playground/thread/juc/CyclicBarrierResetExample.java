package com.yangfan.playground.thread.juc;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrierResetExample {
    private static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(NUMBER_OF_THREADS, () -> {
            // 这个任务在所有线程到达屏障时运行
            System.out.println("所有线程都到达了屏障点，屏障被触发");
        });

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            new Thread(new Worker(barrier)).start();
        }

        // 重置CyclicBarrier，模拟某些场景下的需要
        try {
            Thread.sleep(3000); // 等待足够的时间，确保所有线程都在等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("重置CyclicBarrier");
        barrier.reset(); // 重置屏障，让所有等待的线程抛出BrokenBarrierException
    }

    static class Worker implements Runnable {
        private CyclicBarrier barrier;

        public Worker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " 正在等待屏障");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " 通过了屏障");
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println(Thread.currentThread().getName() + " 被中断或屏障被重置");
            }
        }
    }
}
