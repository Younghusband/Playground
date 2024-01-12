package com.yangfan.playground.thread;
/**
 * 
 * 如果不加volatile   : run方法不会停止，同时查看isRunning的值为false (主内存)
 * 加了volatile     	 : run方法3秒后停止。
 *
 */

public class VolatileDemo {
	
//	private static boolean isRunning = true;  // 不会跳出死循环
	private static volatile boolean isRunning = true;
	private void setRunning(boolean flag){
		this.isRunning = flag;
	}


	private static volatile boolean flag = false;  // 使用volatile修饰共享变量
	
	public static void main(String[] args) throws Exception{
		VolatileDemo rt = new VolatileDemo();

		new Thread(
			() -> {
				System.out.println(Thread.currentThread().getName()+"进入run方法..");
				while(isRunning==true){
//					System.out.println("----"+isRunning);    // 这个会刷新工作内存到主内存，导致不加volatile的情况下也会跳出循环
				}
				System.out.println(Thread.currentThread().getName()+"线程停止");
			}, "t1"
		).start();

		Thread.sleep(3000);
		rt.setRunning(false);
		System.out.println("isRunning的值已被设置为false");
		Thread.sleep(1000);
		System.out.println("isRunning的值为"+rt.isRunning);

//		anotherTest();
	}

	private static void anotherTest() {
		// 线程A修改flag的值
		Thread threadA = new Thread(() -> {
			System.out.println("Thread A starts running.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag = true;
			System.out.println("Thread A sets flag to true.");
		});

		// 线程B读取flag的值
		Thread threadB = new Thread(() -> {
			System.out.println("Thread B starts running.");
			while (!flag) {
				// 等待flag变为true
			}
			System.out.println("Thread B detects flag is true.");
		});

		threadA.start();
		threadB.start();
	}



}
