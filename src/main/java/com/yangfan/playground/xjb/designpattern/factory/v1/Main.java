package com.yangfan.playground.xjb.designpattern.factory.v1;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月23日 上午12:00:14
 *
 *  God是工厂接口
 *  Shehui是工厂类，实现God
 *  People是工厂的抽象产物
 *  programmer，worker是其Shehui工厂的具体产物。
 *
 */

public class Main {
     
	public static void main(String[] args) {
		Shehui god = new Shehui();   //隐藏god
		People p1 = god.zaoRen("worker");
		People p2 = god.zaoRen("programmer");
		
		p1.produce();
		p2.produce();
		
	}
	
}
