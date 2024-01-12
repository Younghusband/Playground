package com.yangfan.playground.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * 测试锁的可重入性
 * 由于synchronized是可重入的，所以在method1的锁被释放之前就可以进入到method2
 * 
 */

public class ReentrantDemo {

	private static Lock lock = new ReentrantLock();

	private void lockMethodOuter() {
		lock.lock();
		System.out.println("Entering lockMethodOuter...");
		lockMethodInner();
		lock.unlock();
		System.out.println("Outer unlocked.");
	}

	private void lockMethodInner() {
		lock.lock();
		System.out.println("Entering lockMethodInner...");
		lock.unlock();
		System.out.println("Inner unlocked.");
	}


	private synchronized void method1(){
		System.out.println(Thread.currentThread().getName()+"-------method1");
		method2();  //测试synchronized的可重入性
	}
	
	private synchronized void method2(){
		System.out.println(Thread.currentThread().getName()+"-------method2");
	}
	

	public static void main(String[] args) {
		ReentrantDemo test = new ReentrantDemo();

//		Thread t1 = new Thread(() -> test.method1(), "Fuck");
//		t1.start();

		Thread t2 = new Thread(() -> test.lockMethodOuter(), "Lock");
		t2.start();


	}

}
