package com.atguigu.gmall.service.imp;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceQueueDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		Object o1 = new Object(); 
		ReferenceQueue<Object> re = new ReferenceQueue<>();
		WeakReference<Object> wr = new WeakReference<Object>(o1,re);
		System.out.println(o1);
		System.out.println(wr.get());
		System.out.println(re.poll());
		
		System.out.println("================");
		
		Thread.sleep(500);
		o1=null;
		System.gc();
		System.out.println(o1);
		System.out.println(wr.get());
		System.out.println(re.poll());
		
		
		
	}
}
