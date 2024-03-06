package com.yangfan.playground.thread.threadlocal;
/**
 * 
 * 不使用ThreadLocal的话，各线程仍能获取到同一个对象的变量
 *
 * 线程生命周期结束的时候，相对应的ThreadLocal会进行GC。
 * 长期存在的线程有内存泄露的风险，所以不管是什么线程，建议使用完ThreadLocal之后都手动调用remove()方法。
 */

public class ThreadLocalDemo {
	public static ThreadLocal<String> th = new ThreadLocal<>();

	// 使用 ThreadLocal 来保存每个线程的计数器
	private static ThreadLocal<Integer> threadCounter = ThreadLocal.withInitial(() -> 0);
	public void set(String str){  
		th.set(str);
	}
	
//	public void set(String str){ //不使用ThreadLocal
//		this.name = str;
//	}
	
	public void get(){  
		System.out.println(Thread.currentThread().getName()+" 获取到  "+th.get());
	} 
	
//	public void get(){ //不使用ThreadLocal
//		System.out.println(Thread.currentThread().getName()+" 获取到  "+name);
//	}
	
	
	
	public static void main(String[] args) {
		final ThreadLocalDemo obj = new ThreadLocalDemo();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				obj.set("yf");
				obj.get();
			}
			
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					Thread.sleep(2000); //确保t1执行完后 t2才获取
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  
				obj.get();
			}
		},"t2");
		
		t1.start();
		t2.start();
		System.out.println(" - ThreadLocal String before remove: " + th.get());

//		testThreadLocal();


	}


	public static void testThreadLocal() {
		Thread t1 = new Thread(() -> {
            int count = threadCounter.get();
            System.out.println("Thread 1 - Initial Counter: " + count);
			for(int i = 0; i < 5; i++) {
				count++;
				threadCounter.set(count);
				System.out.println("Thread 1 - Counter: " + count);
			}
            System.out.println("Thread 1 - final Counter: " + threadCounter.get());
			// remove current thread local variable
			threadCounter.remove();
			System.out.println("Thread 1 - Counter after remove: " + threadCounter.get());
        });



		Thread t2 = new Thread(() -> {
            int count = threadCounter.get();
			System.out.println("Thread 2 - Initial Counter: " + count);
			for(int i = 0; i < 5; i++) {
				count++;
				threadCounter.set(count);
				System.out.println("Thread 2 - Counter: " + count);
			}
			System.out.println("Thread 2 - final Counter: " + threadCounter.get());
			// remove current thread local variable
			threadCounter.remove();
			System.out.println("Thread 2 - Counter after remove: " + threadCounter.get());
        });
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main Thread - Counter: " + threadCounter.get());
	}
	
}
