package com.yangfan.playground.thread.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * 1. 在每个执行的线程中进行countDown()操作
 * 2. 在外部需要等待的地方进行await()操作
 *
 * 上述操作都是指CountDownLatch对象的方法。
 *
 * 每个执行的线程并不会阻塞，阻塞的是外部调用await()的地方。
 *
 */


class TestTask implements Runnable{
    
	private CountDownLatch latch;
	private int sleepTime;
	
	public TestTask(CountDownLatch latch, int sleepTime){
		this.latch = latch;
		this.sleepTime = sleepTime;
	}
	
	
	@Override
	public void run() {
		try {
			CountDownLatchTest.print("entering...");  //10个线程是乱序打印这句
			TimeUnit.SECONDS.sleep(sleepTime);
			CountDownLatchTest.print("finished!!!!!");    //10个线程依次打印这句
			TimeUnit.SECONDS.sleep(1);  //每个线程延迟一秒countDown
			latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}



public class CountDownLatchTest {
	
	private static final int THREAD_NUM = 10;
	
	public static void main(String[] args){
		ExecutorService cachePool = Executors.newFixedThreadPool(THREAD_NUM);
		final CountDownLatch latch = new CountDownLatch(THREAD_NUM);
		for (int i = 1; i <= THREAD_NUM; i++) {
			cachePool.execute(new TestTask(latch, i));
		}
		
		try {
			latch.await(); // 10个线程会直到计数器到0才会往下走
			CountDownLatchTest.print(">>>>>Continued...");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			cachePool.shutdown();
		}
		
	}
	
	
	
	public static void print(String str){
		SimpleDateFormat date = new SimpleDateFormat("HH");
		System.out.println("["+date.format(new Date())+"]"+Thread.currentThread().getName()+"  "+str);
	}

}
