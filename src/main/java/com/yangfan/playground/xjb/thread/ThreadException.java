package com.yangfan.playground.xjb.thread;

/**
 * 
 * 线程中发生异常
 *
 */

public class ThreadException {

	private int i = 0;

	public synchronized void add() {
		while (true) {
			try {
				i++;
				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName() + ", i = " + i);
				if (i%10 == 0) {
					Integer.parseInt("a"); // throw new RuntimeException();
				}
			} catch (Exception e) {
				System.out.println("error! i = " + i);
				// 具体的处理 或者throw new Exception();
				throw new RuntimeException(e);  // 为了激活main线程
			}

		}

	}

	public static void main(String[] args) {
	   final ThreadException sync = new ThreadException();
	   Thread t1 = new Thread(() -> sync.add(),"t1");
	   t1.start();
	   try{
		   t1.join();
		  sync.add();  //主线程
		  Thread.sleep(20000);   //由于while一直在循环，这个sleep走不到
	   } catch (Exception e) {
		   System.out.println("main error");
		  try {
				t1.join(); // t1已经shutdown了，无法join
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		   throw new RuntimeException(e);
	   }

	}

}
