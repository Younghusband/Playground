package com.yangfan.playground.thread.app.abc;
/**
 * 该实现能运行，但是强依赖加锁和执行顺序
 * 并且有嵌套synchronized
 *
 * 不推荐该实现方法，能跑起来但是我自己都看不明白为什么会正确执行...
 *
 * 推荐通过计数器+notifyAll的方式来轮询打印
 */

public class ABC implements Runnable{
	private Object outer;
	private Object inner;
	
   public ABC(Object outer, Object inner){
	   this.outer = outer;
	   this.inner = inner;
   }

	@Override
	public void run() {
		int count = 10;
		while(count > 0) {
			synchronized(outer) {
				synchronized(inner) {
					System.out.println(Thread.currentThread().getName()+"---"+count--);
					inner.notifyAll();
				}
				try {
					Thread.sleep(1);
					outer.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Object lockA = new Object();
		Object lockB = new Object();
		Object lockC = new Object();

		// 看斜对角，只需要将上一个线程的outer 锁对准下一个线程的inner锁就可以一直执行下去
		ABC one = new ABC(lockB, lockA);
		ABC two = new ABC(lockC, lockB);
		ABC three = new ABC(lockA, lockC);
		
		Thread A = new Thread(one,"A"); // B enter -> A enter, A release -> B release
		Thread B = new Thread(two,"B"); // C enter -> B enter, B release -> C release
		Thread C = new Thread(three,"C"); // A enter -> C enter, C release -> A release
		
			try {
				A.start();
				Thread.sleep(1); // 两个sleep保证初始时是ABC
				B.start();
				Thread.sleep(1);
				C.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
