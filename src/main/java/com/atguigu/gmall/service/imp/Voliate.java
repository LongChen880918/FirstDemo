package com.atguigu.gmall.service.imp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyData{
   volatile int num =0;
	public void addT060() {
		this.num=60;
	}
}
/*
 * 验证volatile的可见性
 * 1.假如int num=0;假如num变量之前根本没有添加volatile关键词修饰
 */
public  class Voliate {
	public static void main(String[] args) {
		MyData myData = new MyData();
		Lock lock = new ReentrantLock();
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t come in");
			try {
				TimeUnit.SECONDS.sleep(3);
				myData.addT060();
				System.out.println(Thread.currentThread().getName()+"\t updated number value:"+myData.num);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		},"AAA").start();
		while(myData.num==0) {
			//main线程就一直在这里等待循环，知道number值不再为0
		}
		System.out.println(Thread.currentThread().getName()+"\t mission is over");
		
		
	}
}
