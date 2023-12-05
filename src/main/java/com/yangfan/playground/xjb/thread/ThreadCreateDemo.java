package com.yangfan.playground.xjb.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @description 线程创建的几种方式
 *
 * 1. 继承Thread类
 * 2. 实现Runnable接口
 * 3. 实现Callable接口
 * 4. 使用线程池
 */
public class ThreadCreateDemo {

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();

        // 1. 继承Thread类
        Thread thread1 = new Thread(() -> System.out.println("===Thread created by \"new Thread\""));

        // 2. 实现Runnable接口(匿名内部类)
        Runnable runnable = () -> System.out.println("===Thread created by \"new Thread(new Runnable())\"");
        Thread thread2 = new Thread(runnable);

        // 3. 实现Callable接口
        FutureTask futureTask = new FutureTask(() -> {
            System.out.println("===Thread created by \"new FutureTask(new Callable())\"");
            return null;
        });

        Thread thread3 = new Thread(futureTask);



        threadList.add(thread1);
        threadList.add(thread2);
        threadList.add(thread3);

        threadList.forEach(Thread::start);
            // 4. 使用线程池
        ExecutorService executorService = Executors.newWorkStealingPool();
        executorService.submit(() -> System.out.println("===Thread created by \"ExecutorService.newWorkStealingPool\""));
        executorService.shutdown();
    }



}
