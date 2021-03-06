package com.atguigu.gmall.service.imp;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		Object o1 = new Object();
		ReferenceQueue<Object> referenceQueue = new ReferenceQueue();
		PhantomReference<Object> phantoReference = new PhantomReference<Object>(o1,referenceQueue);
		
		System.out.println(o1);
		System.out.println(referenceQueue.poll());
		System.out.println(phantoReference.get());
		System.out.println("========================");
			
		o1 = null;
		System.gc();
		Thread.sleep(500);
		System.out.println(o1);
		System.out.println(referenceQueue.poll());
		System.out.println(phantoReference.get());
	
	}
}
