package com.yangfan.playground.xjb.thread;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月3日 下午9:45:36
 * 
 * 脏读
 *   
 */

public class DirtyReadDemo {
	
	private String user = "root";
	private String password = "12345";
	
	public synchronized void setValue(String u, String p){
		System.out.println("setValue方法获得的数据:  user = "+u+" password = "+p);
	    System.out.println(Thread.currentThread().getName()+"---------------------修改中---------------------");  //只是为了看main线程和t1线程谁跑在前面
		this.user = u;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.password = p;
		
	}
	
	/**synchronized */
	public void getValue(){  //不加synchronized就会产生脏读
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +": getValue方法获得的数据:  user = "+user+" password = "+password);
		
	}
	
	public synchronized void over(){
		System.out.println("over----------------------------");
	}
	
	public static void main(String []args) throws InterruptedException {
		final DirtyReadDemo dirty = new DirtyReadDemo();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				dirty.setValue("yf", "fuckyou");
			}
		},"t1");
		
		t1.start();
		try {
			Thread.sleep(500);   // 如果不加这个，则有可能直接读出未修改的数据
			// 也不能用t1.join 那样会无法产生脏读
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		dirty.getValue();   //这个时候应该读到yf, fuckyou 这一套值才对
		dirty.over();
		
	}

	
	
}
