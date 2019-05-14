package com.atguigu.gmall.service.imp;

import java.util.concurrent.atomic.AtomicInteger;

class MyDate{
	volatile int num = 0;
	public void addT060() {
		this.num++;
	}
	AtomicInteger atomicInteger = new AtomicInteger();
	public synchronized void  addMyAtomic() {
		atomicInteger.getAndIncrement();
	}
	
}

public class VoliateDemo {
	public static void main(String[] args) {
		MyDate mydate = new MyDate();
		for(int i=0;i<=20;i++) {
			new Thread(()->{
				for(int j=1;j<=1000;j++) {
					mydate.addT060();
//					mydate.addMyAtomic();
				}
			},String.valueOf(i)).start();
		}
		
		System.out.println(mydate.num);
	}
	
}
