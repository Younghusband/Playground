package com.yangfan.playground.xjb.designpattern.singleton;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月21日 下午7:48:48
 * 
 * 懒汉式 双重校验锁
 * 
 * 锁优化 加锁的位置很关键
 * 
 * 为什么在同步块内还要再检验一次？
 * 因为可能会有多个线程（各个线程均处于instance==null的状态）一起进入同步块外的
 * 其中有一个线程拿到了锁初始化了instance, 其他排队的线程进来需要再次判断if(instance == null)
 * 从而保证了不会重复创建实例
 * 
 * 这段代码看起来很完美，很可惜，它是有问题。主要在于instance = new SingletonLazyPro()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。

	给 instance 分配内存
	调用 SingletonLazy 的构造函数来初始化成员变量
	将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
	
	但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。
	如果是后者，线程一在 3 执行完毕、2 未执行之前，线程二走到了第一个if(instance == null)，这时 instance 已经是非 null 了(但却没有初始化)。
    此时线程二会直接返回 instance，然后使用，然后顺理成章地报错(nullpointer)。
	我们只需要将 instance 变量声明成 volatile 就可以了。
 * 
 *  使用 volatile 的主要原因是其另一个特性：禁止指令重排序优化
 */

public class SingletonLazy {
	private volatile static SingletonLazy instance;
	private SingletonLazy() {
		if(instance != null) {
			throw new RuntimeException("禁止通过反射实例化对象");
		}
	}

	private Object readResolve() {
		return instance;
	}

	public static SingletonLazy getInstance() {
		if (instance == null) {
			synchronized (SingletonLazy.class) {
				if (instance == null) { // 没拿到锁的线程恢复后，需要用到这个判断，否则它也会再创建一个
					instance = new SingletonLazy();
				}
			}
		}
		return instance;
	}

}
