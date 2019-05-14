package com.atguigu.gmall.service.imp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		
		
		return 1024;
	}
	
}


/**
 * 多线程的获得方式
 * @author ASUS
 *
 */
public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> a = new FutureTask<>(new MyThread()); 
		
		Thread t1 = new Thread(a,"AAA");
		t1.start();
		while(!a.isDone()) {
			
		}
		
		
		System.out.println("****result:"+a.get());
		
	}
	
}
