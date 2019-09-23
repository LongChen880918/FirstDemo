package com.atguigu.gmall.service.imp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{
	
	int a;
	
	public MyThread(int a){
		this.a=a;
	}
	
	@Override
	public Integer call() throws Exception {
		if(a==1) {
			return 100;
		}
		if(a==2) {
			return 200;
		}
		return 300;
	}
	
}


/**
 * 多线程的获得方式
 * @author ASUS
 *
 */
public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> a = new FutureTask<Integer>(new MyThread(3)); 
		ExecutorService b = Executors.newFixedThreadPool(10);
		Future<Integer> c = (Future<Integer>) b.submit(a);
		
		
		
		for(int i=0;i<10;i++) {
			
			Integer d = c.get();
			System.out.println(d);
			
		}
//		
//		Thread t1 = new Thread(a,"AAA");
//		t1.start();
//		while(!a.isDone()) {
//			
//		}
//		
		
		System.out.println("****result:"+a.get());
		
	}
	
}
