package com.yangfan.playground.thread.juc;

import com.yangfan.playground.util.StringUtil;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Semaphore 正如字面意思信号量
 * 设置一个阈值，比如3。然后有n个线程争抢这3个信号量，同时执行的线程最多只能有3个。
 * 
 * 举个例子，如下代码，十个线程竞争三个资源，一开始有三个线程可以直接运行，剩下的七个线程只能阻塞等到其它线程使用资源完毕才能执行
 * 
 * 这里的例子:  厕所一共3个坑位，10个人上厕所
 *
 * 有点像锁, acquire()像lock()  release()像unlock()
 *
 */

public class SemaphoreTest {
	
	private static final int THREAD_NUM = 10;
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);  //10个线程
		Semaphore s = new Semaphore(3);   //3个坑位
		Random rand = new Random();
		for (int i = 1; i <= THREAD_NUM; i++) {
			pool.execute(
				() -> {
					print(" 排队蹲坑。。。");
					try {
						s.acquire();
						//下面3行为实际你要处理的业务，这里用蹲坑模拟
						print(" 占领坑位！！！！");
						TimeUnit.SECONDS.sleep(rand.nextInt(10));
						print(" 拉完屎出坑。");
						s.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			);
		}
		
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.shutdown();
		}
		
		while (true) {
			if (pool.isTerminated()) { //线程池shutdown之后
				System.out.println("---END---\n");
				System.out.println("所有的子线程都结束了！");
				break;
			}
		}

	}

	private static void print(String xxx) {
		StringUtil.printTimeAndThreadInfo(xxx);
	}

}
