package com.atguigu.gmall.service.imp;

import java.math.BigDecimal;

public class SingletonDemo {
	private static volatile SingletonDemo instance=null;
	private SingletonDemo() {
		System.out.println(Thread.currentThread().getName()+"\t 我是构造方法SingletonDemo()");
	}
	
	//DCL(Double check Lock双端检索机制)
	public static  SingletonDemo getInstance() {
		if(instance==null) {
			synchronized (SingletonDemo.class) {
				if(instance==null) {
					instance=new SingletonDemo();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		//单线程（main线程的操作。。。。）
//		System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//		System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//		System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//		
		//并发多线程后，情况发生了很大的变化
		for(int i=1;i<=10;i++) {
			new Thread(()->{
				SingletonDemo.getInstance();
			},String.valueOf(i)).start();
		}
		
		BigDecimal a = new BigDecimal("0.3");
		BigDecimal b = new BigDecimal("0.2");
		System.out.println(a.subtract(b));
		
		
		
	}
}
