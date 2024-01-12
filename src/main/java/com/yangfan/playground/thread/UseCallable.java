package com.yangfan.playground.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年4月2日 下午6:54:20
 *
 * 可以获得返回值的线程
 */

public class UseCallable {

	
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//创建一个callable
		Task1 callableTask = new Task1();
		//用futureTask包装器
		FutureTask future = new FutureTask(callableTask);
		Thread t = new Thread(future);
		t.start();
		System.out.println("main thread 在等future返回，可以做其他事情");
		System.out.println("future.get() = "+future.get());
	}
	
	
}



class Task1 implements Callable {
	@Override
	public Object call() throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+"-------");
		Thread.sleep(2000);
		return 1;
	}
	
	
}