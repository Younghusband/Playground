package com.yangfan.playground.xjb.design.callback.demo;




/**
 * 回调接口
 * 调用顺序是：Caller -> ICallBack -> Caller
 */
public class Caller {
    
    public void execute(ICallBack callback) throws InterruptedException {
        System.out.println("--------ready to call--------");
        callback.call();
        System.out.println("--------finish the call--------");
    }
    
    
    public static void main(String[] args) throws InterruptedException {
        Caller caller = new Caller();
        caller.execute(
            () -> {
                System.out.println("--------call back begin--------");
                Thread.sleep(2000);
                System.out.println("--------call back end--------");
            }
        );
        
    }

}
