package com.yangfan.playground.xjb.thread;
/**
 * 测试线程的优先级问题。
 * Thread.setPriority()可能根本不做任何事情，这跟你的操作系统和虚拟机版本有关
 * 不要假定高优先级的线程一定先于低优先级的线程执行，不要有逻辑依赖于线程优先级，否则可能产生意外结果
 */

public class ThreadPriority {

	public static void main(String[] args) {
		Runnable runnable = () -> {
            Thread currentThread = Thread.currentThread();
            for(int i=0; i<10; i++){
                System.out.println(currentThread.getName()+"----priority:"+currentThread.getPriority());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

		Thread t1 = new Thread(runnable,"t1");
		Thread t2 = new Thread(runnable,"t2");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		try {
			t1.start();
			t2.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
