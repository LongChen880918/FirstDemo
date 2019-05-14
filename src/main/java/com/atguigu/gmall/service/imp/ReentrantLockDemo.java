package com.atguigu.gmall.service.imp;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	volatile int n =0;
	public synchronized void add() {
		n++;
	}
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		BigDecimal a = new BigDecimal(0.2);
		BigDecimal b = new BigDecimal(0.3);
		
		System.out.println(b.subtract(a));
	}
	
}
