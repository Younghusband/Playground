package com.yangfan.playground.thread.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * 用于测试fork-join
 */
public class Main {

    public static void main(String[] args) {
        // 创建2000个随机数组成的数组
        long [] array = new long[2000];
        long expectedSum = 0;
        for(int i = 0; i < array.length; i++) {
            long randomN = random();
            expectedSum += randomN;
            array[i] = random();
        }
        System.out.println("Expected sum:" + expectedSum);

        // calculate by fork/join
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        // invoke 同步阻塞  submit 异步future   commonPool不需要手动关闭
        Long result = ForkJoinPool.commonPool().invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/Join sum: " + result + " in " + (endTime - startTime) + " ms. ");
    }


    static Random random = new Random(0);

    static long random() {
        return random.nextInt(10000);
    }


}
