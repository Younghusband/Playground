package com.yangfan.playground.xjb.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月5日 下午8:38:45
 * 
 * Atomic的用法。
 * Atomic能保证单次操作的原子性，但多次操作并不具有原子性。 仍需要synchronized
 */

public class AtomicUse {
	private static AtomicInteger count = new AtomicInteger(0);

	private static int countOfCount = 0;
	
	
	/* synchronized */
	public int multiAdd(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count.addAndGet(1);
		count.addAndGet(2);
		count.addAndGet(3);
		count.addAndGet(4);    //如果原子性不被打破的话，结果必然都是10的整数倍
		return count.get();
	}
	
	public static void main(String[] args) {
		AtomicUse au = new AtomicUse();
		List<Thread> threadlist = new ArrayList<>();

		// 亲测10以上会出现不是10的整数倍的情况
		for(int i=0; i<11; i++){
			Thread t = new Thread(() -> {
                int v = au.multiAdd();
                System.out.println("第"+ ++countOfCount+"次累加后的值为" + v);
            });

			threadlist.add(t);
		}
		for(Thread t:threadlist){
			t.start();
		}
		
	}
	

}
