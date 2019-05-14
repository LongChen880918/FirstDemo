package com.atguigu.gmall.service.imp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
	AtomicReference<Thread> aa = new AtomicReference<>();
	
	public void myLock() {
		Thread thread = Thread.currentThread();
		System.out.println(Thread.currentThread().getName()+"\t come in");
		while(!aa.compareAndSet(null, thread)) {
			
		}
	
	}
	public void myUnlock() {
		Thread thread = Thread.currentThread();
		aa.compareAndSet(thread, null);
		System.out.println(Thread.currentThread().getName()+"\t invoked myUnlock()");
	}
	
	/*
	 * 手写一个自旋锁
	 * 循环比较获取值到成功为止
	 */
	public static void main(String[] args) {
		//原子引用线程
		
		SpinLockDemo bb = new SpinLockDemo();
		new Thread(()->{
			try {
				bb.myLock();
				TimeUnit.SECONDS.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
			bb.myUnlock();
		},"AA").start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Thread(()->{
			bb.myLock();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			bb.myUnlock();
			
		},"BB").start();
		
		
		
	}
	
}
