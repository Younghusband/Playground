package com.yangfan.playground.thread.future;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月7日 下午4:37:08
 */

public class Client {
     
	 public Data request(final String qryStr){
		  final FutureData future = new FutureData();
		  new Thread(){
			 @Override
			 public void run(){
				 RealData real = new RealData(qryStr);  //耗时操作  装载realdata
				 future.setRealData(real);
			 }
		 }.start();
		  return future;   //主线程直接返回
	 }
	
}
