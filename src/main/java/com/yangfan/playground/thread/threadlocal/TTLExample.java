package com.yangfan.playground.thread.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

public class TTLExample {
    private static final TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        context.set("Value set in parent thread");

        Runnable task = () -> {
            System.out.println("Thread context: " + context.get());
        };
        Runnable ttlRunnable = TtlRunnable.get(task);
        Thread thread = new Thread(ttlRunnable);
        thread.start();
    }
}
