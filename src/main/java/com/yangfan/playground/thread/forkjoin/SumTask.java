package com.yangfan.playground.thread.forkjoin;

import java.util.concurrent.RecursiveTask;


/**
 * 任务的模型，含有什么属性，怎么拆分都是由自己定义
 */
public class SumTask extends RecursiveTask<Long> {

    static final int THRESHOLD = 500;
    long [] array;
    int start;
    int end;

    SumTask(long [] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if(end - start <= THRESHOLD) {
            // 如果任务足够小，直接计算
            long sum = 0;
            for(int i = start; i < end; i++) {
                sum += this.array[i];
                // 故意放慢计算速度
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {

                }
            }
            return sum;
        }
        // 任务太大，拆分
        int middle = (start + end)/2;
        System.out.printf("split %d~%d ==> %d~%d, %d~%d%n", start, end, start, middle, middle, end);
        SumTask subTask1 = new SumTask(this.array, start, middle);
        SumTask subTask2 = new SumTask(this.array, middle, end);
        invokeAll(subTask1, subTask2);
        Long subResult1 = subTask1.join();
        Long subResult2 = subTask2.join();
        Long totalResult = subResult1 + subResult2;
        System.out.println("result = " + subResult1 + " + " + subResult2 + "==>" + totalResult);
        return totalResult;
    }


}
