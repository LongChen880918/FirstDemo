package com.atguigu.gmall.service.imp;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1 CAS是什么？===>CompareAndSet
 *	 比较并交换
 */

public class CASDemo {
	public static void main(String[] args) {
		AtomicInteger atomicInteger =new AtomicInteger(5);
		
		//main do thing ...
		System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data:"+atomicInteger.get());
		System.out.println(atomicInteger.compareAndSet(5, 2014)+"\t current data:"+atomicInteger.get());
		
		atomicInteger.getAndIncrement();
	}
}
