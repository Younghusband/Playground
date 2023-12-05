package com.yangfan.playground.xjb.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 100个线程，每个线程做i++和使用atomic实现的cas计数器各一万次，最后打印出来的结果是多少
 *
 * 预期结果
 * 前者: <1000000
 * 后者：1000000
 *
 * 代码是演示cas的使用，实际上atomic已经帮我们实现了一个线程安全的计数器
 * 比如incrementAndGet()方法，内部就是使用了cas
 *
 */

public class CasTest {

    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i = 0;
    public static void main(String[] args) {
        final CasTest cas = new CasTest();
        List<Thread> ts = new ArrayList<Thread>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }

        for (Thread t : ts) {
            t.start();
        }
        // 等待所有线程执行完成
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.printf("耗时%s ms\n", System.currentTimeMillis() - start);

    }

    /**
     * 使用CAS实现线程安全计数器
     */

    private void safeCount() {
        // 无限自旋
        for (; ; ) {
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
//        atomicI.incrementAndGet();  // 等同于上面那段
    }

    /**
     * 非线程安全计数器
     */

    private void count() {
        i++;
    }

}

